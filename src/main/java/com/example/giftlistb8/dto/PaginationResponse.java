package com.example.giftlistb8.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record PaginationResponse<T>(
        List<T> elements,
        int currentPage,
        int pageSize
) {
}
