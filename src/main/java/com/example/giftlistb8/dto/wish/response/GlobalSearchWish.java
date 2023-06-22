package com.example.giftlistb8.dto.wish.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public record GlobalSearchWish(
        Long id,
        String firstName,
        String lastName,
        String wishName,
        String wishImage,
        String phoneNumber,
        String description,
        boolean status,
        String country
) {
    public GlobalSearchWish(Long id, String firstName, String lastName, String wishName, String wishImage, String phoneNumber, String description, boolean status, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wishName = wishName;
        this.wishImage = wishImage;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.status = status;
        this.country = country;
    }
}
