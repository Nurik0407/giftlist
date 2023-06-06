package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.wish.responses.WishResponse;
import com.example.giftlistb8.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.image," +
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
}
