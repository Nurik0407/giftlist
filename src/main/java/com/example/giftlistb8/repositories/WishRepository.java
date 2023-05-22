package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.wish.responses.WishResponse;
import com.example.giftlistb8.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish,Long> {
    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.image,w.status) from Wish w where w.id=:id and w.isBlocked=false ")
    Optional<WishResponse> findWishById(Long id);

    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.image,w.status) from Wish w where  w.isBlocked=false")
    List<WishResponse> findAllWishes();
}