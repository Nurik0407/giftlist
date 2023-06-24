package com.example.giftlistb8.dto.charity.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CharitiesResponse(
        Long userId,
        String fullName,
        String userImage,
        Long id,
        String charityName,
        String image,
        LocalDate dateAdded,
        String state,
        String reserveUserImage,
        boolean isReserved,
        boolean isAnonymous
) {}
