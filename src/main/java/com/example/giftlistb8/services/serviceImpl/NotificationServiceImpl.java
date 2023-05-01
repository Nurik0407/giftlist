package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.notification.response.NotificationResponse;
import com.example.giftlistb8.repositories.custom.NotificationRepositoryCustom;
import com.example.giftlistb8.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepositoryCustom notificationRepositoryCustom;

    @Override
    public List<NotificationResponse> getAllMyNotifications(Long userId) {
        return notificationRepositoryCustom.getAll(userId);
    }
}
