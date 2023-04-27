package com.example.giftlistb8.dto.feed.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record SimpleResponse(
        HttpStatus httpStatus,
        String message) {
}
