package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityRepository extends JpaRepository<Charity, Long> {
}