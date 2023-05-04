package com.example.giftlistb8.dto.profile.response;

import lombok.Builder;

@Builder
public record ProfileResponseGetById(
        Long id,
        String image,
        String fullName,
        String email

) {
}
