package com.example.giftlistb8.dto.wish.response;

import java.time.LocalDate;

public record WishResponseUser(
        Long id,
        String image,
        String nameWish,
        String nameHoliday,
        LocalDate date,
        String status
) {
}
