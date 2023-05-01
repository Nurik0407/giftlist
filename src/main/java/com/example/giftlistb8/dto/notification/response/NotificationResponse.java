package com.example.giftlistb8.dto.notification.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record NotificationResponse(
        Long userId,
        String fullName,
        String type,
        String message,
        LocalDate createdAt
) {
}
