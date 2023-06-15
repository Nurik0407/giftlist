package com.example.giftlistb8.dto.user.response;

import lombok.Builder;

@Builder
public record UserResponseGetAll(
        Long id,
        String photo,
        String fullName,
        int count,
        boolean isBlocked
) {
}
