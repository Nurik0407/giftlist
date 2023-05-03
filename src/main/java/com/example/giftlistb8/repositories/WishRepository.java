package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<Wish, Long> {
}
