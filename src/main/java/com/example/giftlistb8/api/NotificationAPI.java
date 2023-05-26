package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.notification.response.NotificationResponse;
import com.example.giftlistb8.services.NotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@Tag(name = "Notification API", description = "Manage user notifications.")
@CrossOrigin(origins = "*")
@PreAuthorize("hasAuthority('ADMIN')")
public class NotificationAPI {
    private final NotificationService notificationService;

    @GetMapping
    public List<NotificationResponse> getAllNotifications() {
        return notificationService.getAllMyNotifications();
    }

    @PostMapping
    public SimpleResponse markAllAsRead() {
        return notificationService.markAllAsRead();
    }
}
