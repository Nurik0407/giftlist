package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.notification.response.NotificationResponse;
import com.example.giftlistb8.entities.Notification;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.repositories.NotificationRepository;
import com.example.giftlistb8.repositories.custom.NotificationRepositoryCustom;
import com.example.giftlistb8.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepositoryCustom notificationRepositoryCustom;
    private final NotificationRepository notificationRepository;
    private final JwtService jwtService;

    @Override
    public List<NotificationResponse> getAllMyNotifications() {
        return notificationRepositoryCustom.getAll();
    }

    @Override
    public SimpleResponse seenOrNot() {
        List<Notification> notifications = jwtService.getUserInToken().getMyNotifications();

        for (int i = 0; i < notifications.size(); i++) {
            notifications.get(i).setSeen(true);
            notificationRepository.save(notifications.get(i));
        }
        return SimpleResponse.builder().
                status(HttpStatus.OK).
                message("Seen Status changed ")
                .build();
    }
}
