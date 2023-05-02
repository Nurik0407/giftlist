package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
}