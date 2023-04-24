package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.auth.SimpleResponse;
import com.example.giftlistb8.dto.auth.user.requests.ResetPasswordRequest;
import com.example.giftlistb8.services.UserInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user/")
public class UserAPI {
    private final UserInfoService userService;

    @PostMapping("/forgot_password")
    public SimpleResponse processForgotPassword(@RequestParam String email) {
        return userService.updateResetPasswordToken(email);
    }

    @PostMapping("/reset_password")
    public SimpleResponse processResetPassword(@RequestParam String token, @RequestBody @Valid ResetPasswordRequest request) {
        return userService.getByResetPasswordToken(token, request.getPassword(), request.getConfirmPassword());
    }
}
