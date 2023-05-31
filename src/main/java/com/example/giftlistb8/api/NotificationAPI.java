package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.notification.response.NotificationResponse;
import com.example.giftlistb8.services.NotificationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@Tag(name = "Notification API", description = "Manage user notifications.")
@CrossOrigin(origins = "*")
public class NotificationAPI {
    private final NotificationService notificationService;

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<NotificationResponse> getAllNotifications() {
        return notificationService.getAllMyNotifications();
    }

    @PostMapping
    @PermitAll
    public SimpleResponse markAllAsRead() {
        return notificationService.markAllAsRead();
    }

    @GetMapping("/complaints")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<NotificationResponse> getAllComplaintNotifications(){
        return notificationService.getAllComplaintNotifications();
    }
}
