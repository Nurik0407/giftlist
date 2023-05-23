package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HolidayRepository extends JpaRepository<Holiday, Long> {
}