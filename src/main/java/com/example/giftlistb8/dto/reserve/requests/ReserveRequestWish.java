package com.example.giftlistb8.dto.reserve.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record ReserveRequestWish(
        @NotNull(message = "Wish ID cannot be null")
        @Positive(message = "Wish ID must be greater than 0")
        Long  wishId,
        Boolean isAnonymous


) {
}
