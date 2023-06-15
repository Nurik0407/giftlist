package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.holiday.response.GlobalSearchHoliday;
import com.example.giftlistb8.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface HolidayRepository extends JpaRepository<Holiday, Long> {
    @Query("SELECT NEW com.example.giftlistb8.dto.holiday.response.GlobalSearchHoliday(h.id, u.firstName, u.lastName, h.name, h.image, h.date) " +
            "FROM User u " +
            "JOIN u.holidays h " +
            "WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(h.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<GlobalSearchHoliday> globalSearch(@Param("keyword") String keyword);}