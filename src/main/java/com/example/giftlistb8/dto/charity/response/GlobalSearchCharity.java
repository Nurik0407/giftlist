package com.example.giftlistb8.dto.charity.response;

import lombok.Builder;

import java.time.LocalDate;
@Builder
public record GlobalSearchCharity(
        Long id,
        String firstName,
        String lastName,
        String charityName,
        String phoneNumber,
        String image,
        LocalDate dateAdded,
        String countryName,
        String state,
        String category,
        String subCategory,
        boolean isReserved
) {
}
