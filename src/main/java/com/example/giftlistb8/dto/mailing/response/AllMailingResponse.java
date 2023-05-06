package com.example.giftlistb8.dto.mailing.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record AllMailingResponse(
        String image,
        String title,
        LocalDateTime createdAt
) {

}
