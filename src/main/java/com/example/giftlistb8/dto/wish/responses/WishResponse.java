package com.example.giftlistb8.dto.wish.responses;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record WishResponse(
    Long id,
    String name,
    String image,
    LocalDate date,
    boolean isReserved,
    boolean isAnonymous,
    String reserveUserImage
){
    public WishResponse(Long id, String name, String image, LocalDate date, boolean isReserved, boolean isAnonymous, String reserveUserImage) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.date = date;
        this.isReserved = isReserved;
        this.isAnonymous = isAnonymous;
        this.reserveUserImage = reserveUserImage;
    }
}
