package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.notification.response.NotificationResponse;
import com.example.giftlistb8.dto.user.requests.ResetPasswordRequest;
import com.example.giftlistb8.services.NotificationService;
import com.example.giftlistb8.services.UserInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserAPI {
    private final UserInfoService userService;
    private final NotificationService notificationService;

    @PostMapping("/forgot_password")
    public SimpleResponse processForgotPassword(@RequestParam String email) {
        return userService.updateResetPasswordToken(email);
    }

    @PostMapping("/reset_password")
    public SimpleResponse processResetPassword(@RequestParam String token, @RequestBody @Valid ResetPasswordRequest request) {
        return userService.getByResetPasswordToken(token, request.getPassword(), request.getConfirmPassword());
    }

    @GetMapping("/notifications")
    public List<NotificationResponse> getAllNotifications(){
        return notificationService.getAllMyNotifications();
    }

    @PostMapping()
    public SimpleResponse seenOrNot(){
        return notificationService.seenOrNot();
    }
}
