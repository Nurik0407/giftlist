package com.example.giftlistb8.dto.mailing.response;

import java.time.LocalDateTime;

public record MailingResponse(
        Long id,
        String image,
        String title,
        String text,
        LocalDateTime createdAd
        ) {
}
