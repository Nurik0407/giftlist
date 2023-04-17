package com.example.giftlistb8.dto.auth.responses;

import lombok.Builder;

@Builder
public record AuthRegisterResponse(
        String email,
        String role,
        String token
) { }
