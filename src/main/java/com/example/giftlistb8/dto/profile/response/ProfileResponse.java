package com.example.giftlistb8.dto.profile.response;

import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public record ProfileResponse(
        Long id,
        String image,
        String firstName,
        String lastName,
        String country,
        LocalDate dateOfBirth,
        String email,
        String phoneNumber,
        String hobby,
        String important,
        ClothingSize clothSize,
        ShoeSize shoeSize,
        String facebookLink,
        String instagramLink,
        String telegramLink,
        String vkLink
) {
}
