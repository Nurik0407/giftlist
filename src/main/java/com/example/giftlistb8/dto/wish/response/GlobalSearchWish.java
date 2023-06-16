package com.example.giftlistb8.dto.wish.response;

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
}
