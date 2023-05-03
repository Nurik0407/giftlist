package com.example.giftlistb8.dto.s3.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record S3Response (
        String url,
        String description,
        HttpStatus status
){}
