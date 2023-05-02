package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.reserve.response.ReserveResponseCharity;
import com.example.giftlistb8.dto.reserve.response.ReserveResponseWish;
import com.example.giftlistb8.entities.Reserve;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    @Query("SELECT NEW com.example.giftlistb8.dto.reserve.response.ReserveResponseWish(" +
            "r.id,CONCAT(r.user.firstName, ' ', r.user.lastName)," +
            " r.user.userInfo.image, r.wish.holiday.name, r.wish.holiday.date, r.wish.name, r.wish.image )" +
            "FROM Reserve r ")
    List<ReserveResponseWish> getAllReversesWish();

    @Query("SELECT NEW  com.example.giftlistb8.dto.reserve.response.ReserveResponseCharity(" +
            " r.id,CONCAT(r.user.firstName,' ', r.user.lastName),r.user.userInfo.image,r.charity.name,r.charity.image,r.charity.state,r.charity.date)" +
            "FROM Reserve r ")
    List<ReserveResponseCharity> getAllReversesCharity();


    @Query("select new com.example.giftlistb8.dto.reserve.response.ReserveResponseWish(" +
            "r.id,concat(r.user.lastName,' ',r.user.firstName) ,r.user.userInfo.image, r.wish.holiday.name, r.wish.holiday.date, r.wish.name,r.wish.image) from Reserve r")
    Page<ReserveResponseWish> getAll(Pageable pageable);

    @Query("select new com.example.giftlistb8.dto.reserve.response.ReserveResponseCharity(r.id,concat(r.user.lastName,' ',r.user.firstName) ,r.user.userInfo.image,r.charity.name,r.charity.image,r.charity.state,r.charity.date) from Reserve r")
    Page<ReserveResponseCharity> getAllCharity(Pageable pageable);
import com.example.giftlistb8.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}