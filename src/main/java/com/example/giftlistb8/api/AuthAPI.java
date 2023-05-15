package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.auth.requests.AuthAuthenticateRequest;
import com.example.giftlistb8.dto.auth.requests.AuthRegisterRequest;
import com.example.giftlistb8.dto.auth.responses.AuthRegisterResponse;
import com.example.giftlistb8.dto.user.requests.ResetPasswordRequest;
import com.example.giftlistb8.services.AuthService;
import com.example.giftlistb8.services.UserInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.google.firebase.auth.FirebaseAuthException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication API", description = "Sign in/Sign up")
@CrossOrigin(origins = "*")
public class AuthAPI {

    private final AuthService authService;
    private final UserInfoService userInfoService;

    @PostMapping("/sign-up")
    public AuthRegisterResponse register(@RequestBody @Valid AuthRegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/sign-in")
    public AuthRegisterResponse authenticate(@RequestBody @Valid AuthAuthenticateRequest request) {
        return authService.authenticate(request);
    }

    @PostMapping("/auth-google")
    public AuthRegisterResponse authWithGoogle(String tokenId) throws FirebaseAuthException {
        return authService.authWithGoogle(tokenId);
    }

    @PostMapping("/forgot-password")
    public SimpleResponse processForgotPassword(@RequestParam String email,@RequestParam String link) {
        return userInfoService.updateResetPasswordToken(email,link);
    }

    @PostMapping("/reset-password")
    public SimpleResponse processResetPassword(@RequestParam String token, @RequestBody @Valid ResetPasswordRequest request) {
        return userInfoService.getByResetPasswordToken(token, request.getPassword(), request.getConfirmPassword());
    }
}
