package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.auth.requests.AuthAuthenticateRequest;
import com.example.giftlistb8.dto.auth.requests.AuthRegisterRequest;
import com.example.giftlistb8.dto.auth.responses.AuthRegisterResponse;
import com.example.giftlistb8.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthAPI {

    private final AuthService authService;

    @PostMapping("/signup")
    public AuthRegisterResponse register(@RequestBody AuthRegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/signin")
    public AuthRegisterResponse authenticate(@RequestBody AuthAuthenticateRequest request) {
        return authService.authenticate(request);
    }
}
