package com.example.giftlistb8.dto.wish.responses;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record WishAllResponse (
        String name,
        String linkGift,
        String image,
        String description,
        LocalDate dateOfHoliday,
        Boolean status,
        Long holidayId,
        Long userId
    ){
}
