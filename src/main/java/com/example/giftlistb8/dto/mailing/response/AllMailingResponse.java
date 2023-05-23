package com.example.giftlistb8.dto.mailing.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record AllMailingResponse(
        Long id,
        String image,
        String title,
        LocalDate createdAt
) {

}
