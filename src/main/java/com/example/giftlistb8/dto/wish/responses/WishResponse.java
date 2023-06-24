package com.example.giftlistb8.dto.wish.responses;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record WishResponse(
        Long id,
        String name,
        String holidayName,
        String image,
        LocalDate dateOfHoliday,
        boolean isReserved,
        boolean isAnonymous,
        String reserveUserImage,
        String description,
        String linkGift) {
}
