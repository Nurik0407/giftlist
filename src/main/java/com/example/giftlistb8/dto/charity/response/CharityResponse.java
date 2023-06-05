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
) {
    public CharityResponse(Long id, String fullName, String phoneNumber, String charityName, String description, String category, String subCategory, String state, LocalDate dateAdded, String image, boolean isReserved, boolean isAnonymous, String bookAgentImage) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.charityName = charityName;
        this.description = description;
        this.category = category;
        this.subCategory = subCategory;
        this.state = state;
        this.dateAdded = dateAdded;
        this.image = image;
        this.isReserved = isReserved;
        this.isAnonymous = isAnonymous;
        this.bookAgentImage = bookAgentImage;
    }
}
