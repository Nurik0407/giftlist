package com.example.giftlistb8.dto.feed.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record FeedResponse(
        Long userId,
        String image,
        String fullName,
        String holidayName,
        String wishName,
        String photo,
        LocalDate date,
        Boolean status,
        String friendPhoto) {
}
