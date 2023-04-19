package com.example.giftlistb8.dto.reserve.requests;

import lombok.Builder;

@Builder
public record ReserveRequestWish(
        Long id,
        Long userId,
        Long  wishId,
        Boolean isAnonymous


) {
}
