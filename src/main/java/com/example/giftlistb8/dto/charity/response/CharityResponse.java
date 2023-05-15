package com.example.giftlistb8.dto.charity.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CharityResponse(
        Long id,
        String fullName,
        String phoneNumber,
        String charityName,
        String description,
        String category,
        String subCategory,
        String state,
        LocalDate dateAdded,
        String image,
        boolean isReserved,
        boolean isAnonymous,
        String bookAgentImage
) {}
