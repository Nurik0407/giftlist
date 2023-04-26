package com.example.giftlistb8.dto.charity.request;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public record CharityRequest(
        String name,
        String state,
        String category,
        String subCategory,
        String description,
        String image
) {}
