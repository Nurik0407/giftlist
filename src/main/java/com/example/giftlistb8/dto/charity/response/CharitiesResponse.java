package com.example.giftlistb8.dto.charity.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CharitiesResponse(
        Long id,
        String fullName,
        String charityName,
        String image,
        LocalDate dateAdded,
        boolean isReserved,
        boolean isAnonymous
) {}
