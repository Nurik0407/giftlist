package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.notification.response.NotificationResponse;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> getAllMyNotifications(Long userId);

    SimpleResponse seenOrNot(Long userId);
}
