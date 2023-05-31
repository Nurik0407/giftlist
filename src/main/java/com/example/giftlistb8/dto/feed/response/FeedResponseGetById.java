package com.example.giftlistb8.dto.feed.response;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record FeedResponseGetById(
        Long userId,
        String image,
        String fullName,
        String holidayName,
        String wishName,
        String description,
        String photo,
        LocalDate date,
        boolean isReserved,
        boolean isAnonymous,
        String friendPhoto
) {
}
