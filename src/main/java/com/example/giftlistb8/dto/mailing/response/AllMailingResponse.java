package com.example.giftlistb8.dto.mailing.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AllMailingResponse(
        String image,
        String title,
        LocalDateTime createdAt
) {

}
