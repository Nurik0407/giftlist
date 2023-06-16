package com.example.giftlistb8.dto.holiday.response;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record GlobalSearchHoliday(
        Long id,
        String firstName,
        String lastName,
        String holidayName,
        String image,
        LocalDate date
) {
}
