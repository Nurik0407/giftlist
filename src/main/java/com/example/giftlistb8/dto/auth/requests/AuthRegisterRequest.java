package com.example.giftlistb8.dto.auth.requests;

import lombok.Builder;

@Builder
public record AuthRegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password
) { }



