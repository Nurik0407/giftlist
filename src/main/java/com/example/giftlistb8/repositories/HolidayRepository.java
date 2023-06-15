package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface HolidayRepository extends JpaRepository<Holiday, Long> {

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM holidays h where h.id = ?1")
    void deleteHoliday(Long id);
}