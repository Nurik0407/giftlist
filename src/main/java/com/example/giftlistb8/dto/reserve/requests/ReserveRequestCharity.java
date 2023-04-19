package com.example.giftlistb8.dto.reserve.requests;

import lombok.Builder;

@Builder
public record ReserveRequestCharity(
        Long id,
        Long userid,
        Long charityId,
        Boolean isAnonymous
) {
}
