package com.example.giftlistb8.dto.auth.responses;

import lombok.Builder;

@Builder
public record AuthRegisterResponse(
        String firstName,
        String lastname,
        String token,
        Long id,
        String email,
        String role
) { }
