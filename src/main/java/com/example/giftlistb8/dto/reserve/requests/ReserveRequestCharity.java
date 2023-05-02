package com.example.giftlistb8.dto.reserve.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record ReserveRequestCharity(
        @NotNull(message = "Charity ID cannot be null")
        @Positive(message = "Charity ID must be greater than 0")
        Long charityId,
        Boolean isAnonymous
) {
}
