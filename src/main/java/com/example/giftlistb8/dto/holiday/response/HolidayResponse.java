package com.example.giftlistb8.dto.holiday.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record HolidayResponse(
        String name,
        String image,
        LocalDate date
) {
}
