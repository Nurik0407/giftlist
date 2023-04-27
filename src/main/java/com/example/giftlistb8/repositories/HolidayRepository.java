package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HolidayRepository extends JpaRepository<Holiday, Long> {
    List<HolidayResponse> getHolidaysByUserEmail(String email);
}