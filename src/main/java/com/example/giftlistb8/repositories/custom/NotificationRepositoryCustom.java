package com.example.giftlistb8.repositories.custom;

import com.example.giftlistb8.dto.notification.response.NotificationResponse;

import java.util.List;

public interface NotificationRepositoryCustom {
    List<NotificationResponse> getAll(Long id);

    List<NotificationResponse> getAllComplaintNotifications();
}
