package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.wish.response.GlobalSearchWish;
import com.example.giftlistb8.dto.wish.responses.WishResponse;
import com.example.giftlistb8.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {
    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.image," +
            "w.dateOfHoliday,w.status,COALESCE(r.isAnonymous,false),COALESCE(case when r.isAnonymous = false then ui.image end,null)) " +
            "FROM Wish w " +
            "LEFT JOIN w.reserve r " +
            "LEFT JOIN r.user u " +
            "LEFT JOIN u.userInfo ui " +
            "where w.id = :id and w.isBlocked = false ")
    Optional<WishResponse> findWishById(Long id);

    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.holiday.name,w.image," +
            "w.dateOfHoliday,w.status,COALESCE(r.isAnonymous,false) ,COALESCE(case when r.isAnonymous = false then ui.image end,null)) " +
            "FROM Wish w " +
            "JOIN w.user u " +
            "LEFT JOIN w.reserve r " +
            "LEFT JOIN r.user ru " +
            "LEFT JOIN ru.userInfo ui " +
            "WHERE u.id=:id and w.isBlocked = false order by w.id desc ")
    List<WishResponse> findAllWishes(Long id);

    @Query("SELECT count(r.id) > 0 FROM Wish w JOIN w.reserve r WHERE w.id = :id")
    boolean isReserved(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "UPDATE wishes SET holiday_id = NULL WHERE user_id = ?1")
    void updateFromHoliday(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "UPDATE reserves SET wish_id = NULL WHERE wish_id IN (SELECT w.id FROM wishes w WHERE w.user_id = ?1)")
    void deleteFromReserveWish(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM wishes WHERE id = ?1")
    void deleteWish(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM wishes_complaints WHERE wish_id = ?1")
    void deleteFromWishComplaints(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM notifications WHERE wish_id = ?1")
    void deleteFromNotification(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM reserves WHERE wish_id = ?1")
    void deleteFromReserve(Long id);
    @Query("SELECT NEW com.example.giftlistb8.dto.wish.response.GlobalSearchWish(w.id, u.firstName, u.lastName, w.name, w.image, ui.phoneNumber, w.description, w.status, ui.country) " +
            "FROM User u " +
            "JOIN u.userInfo ui " +
            "LEFT JOIN u.wishes w " +
            "WHERE LOWER(u.firstName) LIKE LOWER(concat('%', :keyword, '%')) " +
            "OR LOWER(u.lastName) LIKE LOWER(concat('%', :keyword, '%')) " +
            "OR LOWER(w.name) LIKE LOWER(concat('%', :keyword, '%')) " +
            "OR ui.phoneNumber LIKE concat('%', :keyword, '%') " +
            "OR LOWER(ui.country) LIKE LOWER(concat('%', :keyword, '%'))")
    List<GlobalSearchWish> globalSearch(@Param("keyword") String keyword);
}
