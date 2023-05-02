package com.example.giftlistb8.dto.reserve.response;
import lombok.Builder;
import java.time.LocalDate;

@Builder
public record ReserveResponseWish(
        Long id,
        String fullName,
        String photo,
        String holidayName,
        LocalDate date,
        String giftName,
        String image

) {
}
