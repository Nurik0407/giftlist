package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.notification.response.NotificationResponse;
import com.example.giftlistb8.entities.Notification;
import com.example.giftlistb8.repositories.NotificationRepository;
import com.example.giftlistb8.repositories.custom.NotificationRepositoryCustom;
import com.example.giftlistb8.services.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepositoryCustom notificationRepositoryCustom;
    private final NotificationRepository notificationRepository;
    private final JwtService jwtService;

    @Override
    public List<NotificationResponse> getAllMyNotifications() {
        Long id = jwtService.getUserInToken().getId();
        log.info("Get all notifications.");
        return notificationRepositoryCustom.getAll(id);
    }

    @Override
    public SimpleResponse markAllAsRead() {
        List<Notification> notifications = jwtService.getUserInToken().getMyNotifications();
        log.info("Changing seen status of {} notifications.", notifications.size());
        notifications.forEach(s ->
                {s.setSeen(true);
                notificationRepository.save(s);});
        log.info("All notifications seen status changed to true.");
        return SimpleResponse.builder().
                status(HttpStatus.OK).
                message("Seen Status changed ")
                .build();
    }
}
