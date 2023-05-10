package com.example.giftlistb8.dto.mailing.response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
public record MailingResponse(
        Long id,
        String image,
        String title,
        String description,
        LocalDateTime createdAt
) {
}
