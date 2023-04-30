package com.example.giftlistb8.dto.charity.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record CharityResponse(
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
        boolean isAnonymous
) {}
