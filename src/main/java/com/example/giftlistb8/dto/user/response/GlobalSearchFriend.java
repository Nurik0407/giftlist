package com.example.giftlistb8.dto.user.response;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record GlobalSearchFriend(
        Long id,
        String fullName,
        String image,
        String phoneNumber,
        LocalDate dateOfBirth,
        String country,
        String wishName,
        String holidayName,
        String charityName,
        String hobby
) {
}
