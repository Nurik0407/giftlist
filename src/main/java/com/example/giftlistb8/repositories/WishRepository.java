package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.wish.responses.WishResponse;
import com.example.giftlistb8.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishRepository extends JpaRepository<Wish,Long> {
//    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.image,w.status) from Wish w where w.id=:id")
//    Optional<WishResponse> findWishById(Long id);

//    @Query("select new com.example.giftlistb8.dto.wish.responses.WishResponse(w.id,w.name,w.image,w.status) from Wish w")
//    List<WishResponse> findAllWishes();

//    List<Wish> findAll();
//@Query("SELECT new com.example.giftlistb8.dto.wish.responses.WishAllResponse(w.name,w.linkGift,w.image,w.description,w.dateOfHoliday,w.status) FROM Wish w")
//List<WishResponse> findAllWishResponses();
}
