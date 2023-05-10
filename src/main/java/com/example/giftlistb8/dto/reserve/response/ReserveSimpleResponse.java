package com.example.giftlistb8.dto.reserve.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ReserveSimpleResponse(
        HttpStatus status,
        String message,
        Boolean isReserved
) {}
