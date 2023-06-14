package com.example.giftlistb8.dto.notification.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record NotificationResponse(
        Long notificationId,
        Long userId,
        String image,
        String type,
        String message,
        boolean seen,
        LocalDate createdAt
) {
}
