package com.example.giftlistb8.dto.reserve.response;
import lombok.Builder;
import java.time.LocalDate;

@Builder
public record ReserveResponseWish(
        Long reserveId,
        Long wishId,
        String fullName,
        String photo,
        String holidayName,
        LocalDate date,
        String giftName,
        String image

) {
    public ReserveResponseWish(Long reserveId, Long wishId, String fullName, String photo, String holidayName, LocalDate date, String giftName, String image) {
        this.reserveId = reserveId;
        this.wishId = wishId;
        this.fullName = fullName;
        this.photo = photo;
        this.holidayName = holidayName;
        this.date = date;
        this.giftName = giftName;
        this.image = image;
    }
}
