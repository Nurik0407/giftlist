package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.reserve.response.ReserveResponseCharity;
import com.example.giftlistb8.dto.reserve.response.ReserveResponseWish;
import com.example.giftlistb8.entities.Charity;
import com.example.giftlistb8.entities.Reserve;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.entities.Wish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;


public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    @Query("SELECT NEW com.example.giftlistb8.dto.reserve.response.ReserveResponseWish(" +
            "r.id,CONCAT(r.user.firstName, ' ', r.user.lastName)," +
            " r.user.userInfo.image, r.wish.holiday.name, r.wish.holiday.date, r.wish.name, r.wish.image )" +
            "FROM Reserve r where r.charity.isBlocked = false")
    List<ReserveResponseWish> getAllReversesWish();

    @Query("SELECT NEW  com.example.giftlistb8.dto.reserve.response.ReserveResponseCharity(" +
            " r.id,CONCAT(r.user.firstName,' ', r.user.lastName),r.user.userInfo.image,r.charity.name,r.charity.image,r.charity.state,r.charity.dateOfIssue)" +
            "FROM Reserve r where r.wish.isBlocked=false")
    List<ReserveResponseCharity> getAllReversesCharity();


    @Query("select new com.example.giftlistb8.dto.reserve.response.ReserveResponseWish(" +
            "r.id,concat(r.user.lastName,' ',r.user.firstName) ,r.user.userInfo.image, r.wish.holiday.name, r.wish.holiday.date, r.wish.name,r.wish.image) from Reserve r")
    Page<ReserveResponseWish> getAll(Pageable pageable);

    @Query("select new com.example.giftlistb8.dto.reserve.response.ReserveResponseCharity(r.id,concat(r.user.lastName,' ',r.user.firstName) ,r.user.userInfo.image,r.charity.name,r.charity.image,r.charity.state,r.charity.dateOfIssue) from Reserve r")
    Page<ReserveResponseCharity> getAllCharity(Pageable pageable);

    @Query("SELECT r FROM Reserve r WHERE r.user = :user AND r.wish = :wish")
    Optional<Reserve> findByUserAndWish(@Param("user") User user, @Param("wish") Wish wish);

    @Query("SELECT r FROM Reserve r WHERE r.user = :user AND r.charity = :charity")
    Optional<Reserve> findByUserAndCharity(@Param("user") User user, @Param("charity") Charity charity);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Wish w " +
            "LEFT JOIN w.reserve r " +
            "WHERE w.id = :wishId")
    boolean wishReserved(Long wishId);

    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Charity c " +
            "LEFT JOIN c.reserve r " +
            "WHERE c.id = :charityId")
    boolean charityReserved(Long charityId);

    @Query("SELECT CASE WHEN EXISTS " +
            "(SELECT r FROM User u JOIN u.reserves r " +
            "JOIN r.wish w WHERE u.id = ?1 and w.id = ?2) " +
            "THEN FALSE ELSE TRUE END FROM User u WHERE u.id = ?1")
    boolean wishExistInReserve(Long userId, Long wishId);
}
