package com.example.giftlistb8.dto.charity.response;

import java.time.LocalDate;

public record CharityResponseUser(
        Long id,
        String image,
        String name,
        String state,
        LocalDate date,
        String reservePhoto,
        boolean isReserve

) {
}
