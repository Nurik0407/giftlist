package com.example.giftlistb8.dto.mailing.response;

import java.time.LocalDateTime;

public record AllMailingResponse(
        String image,
        String title,
        LocalDateTime createdAt
) {
}
