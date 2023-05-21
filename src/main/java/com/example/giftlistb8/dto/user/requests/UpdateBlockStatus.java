package com.example.giftlistb8.dto.user.requests;

import jakarta.validation.constraints.NotNull;

public record UpdateBlockStatus(
        @NotNull
        Long userId,
        boolean blocked
) {
}
