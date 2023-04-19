package com.example.giftlistb8.dto.reserve.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ReserveResponseCharity(
        Long id,
        String fullName,
        String photo,
        String charityName,
        String state,
        String image,
        LocalDate date

) {
}
