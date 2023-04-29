package com.example.giftlistb8.dto;
import lombok.*;

import java.util.List;

@Builder
public record PaginationResponse<T>(
        List<T> elements,
        int currentPage,
        int pageSize){

}

