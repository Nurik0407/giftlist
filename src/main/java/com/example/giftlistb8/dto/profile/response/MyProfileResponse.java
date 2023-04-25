package com.example.giftlistb8.dto.profile.response;

import lombok.Builder;

@Builder
public record MyProfileResponse(
        Long id,
        String firstName,
        String lastName,
        String email
) {
}
