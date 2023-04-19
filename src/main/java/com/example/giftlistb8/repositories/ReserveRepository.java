package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.reserve.response.ReserveResponseCharity;
import com.example.giftlistb8.dto.reserve.response.ReserveResponseWish;
import com.example.giftlistb8.entities.Charity;
import com.example.giftlistb8.entities.Reserve;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    @Query("SELECT NEW com.example.giftlistb8.dto.reserve.response.ReserveResponseWish(" +
            "r.id,CONCAT(u.firstName, ' ', u.lastName), ui.image,h.name,h.date, w.name, w.image )" +
            "FROM Reserve r " +
            "JOIN r.user u " +
            "JOIN u.userInfo ui " +
            "JOIN r.wish w " +
            "JOIN w.holiday h")
    List<ReserveResponseWish> getAllReversesWish();
    @Query("SELECT NEW  com.example.giftlistb8.dto.reserve.response.ReserveResponseCharity(" +
            " r.id,CONCAT(u.firstName, ' ', u.lastName),ui.image,c.name,SUBSTRING_INDEX(c.images, ',', 1),c.date )" +
            "FROM Reserve r " +
            "JOIN r.user u " +
            "JOIN u.userInfo ui " +
            "JOIN Charity c")
    List<ReserveResponseCharity> getAllReversesCharity();

    @Query("SELECT r FROM Reserve r WHERE r.user = :user AND r.wish = :wish")
    Optional<Reserve> findByUserAndWish(@Param("user") User user, @Param("wish") Wish wish);

    @Query("SELECT r FROM Reserve r WHERE r.user = :user AND r.charity = :charity")
    Optional<Reserve> findByUserAndCharity(@Param("user") User user,@Param("charity") Charity charity);
}