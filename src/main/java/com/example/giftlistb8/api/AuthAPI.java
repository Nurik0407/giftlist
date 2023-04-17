package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.auth.requests.AuthAuthenticateRequest;
import com.example.giftlistb8.dto.auth.requests.AuthRegisterRequest;
import com.example.giftlistb8.dto.auth.responses.AuthRegisterResponse;
import com.example.giftlistb8.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthAPI {

    private final AuthService authService;

    @PostMapping("/signup")
    public AuthRegisterResponse register(@RequestBody @Valid AuthRegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/signin")
    public AuthRegisterResponse authenticate(@RequestBody @Valid AuthAuthenticateRequest request) {
        return authService.authenticate(request);
    }
}