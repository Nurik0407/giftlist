package com.example.giftlistb8.dto.wish.requests;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record WishRequest(
    String name,
    String linkGift,
    Long holidayId,
    LocalDate dateOfHoliday,
    String image,
    String descriptions
){
}
