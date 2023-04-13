package com.example.giftlistb8.dto.auth.requests;
import lombok.Builder;

@Builder
public record AuthAuthenticateRequest(
        String email,
        String password
) { }
