package com.example.giftlistb8.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record SimpleResponse(
        HttpStatus status,
        String message
) {
}