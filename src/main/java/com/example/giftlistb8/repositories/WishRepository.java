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
    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.image,w.status) from Wish w where w.id=:id and w.isBlocked=false ")
    Optional<WishResponse> findWishById(Long id);

    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.image,w.status) from Wish w join w.user u where u.id=:id and w.isBlocked=false order by w.id desc ")
    List<WishResponse> findAllWishes(Long id);

    @Query("SELECT count(r.id) > 0 FROM Wish w JOIN w.reserve r WHERE w.id = :id")
    boolean isReserved(Long id);
}
