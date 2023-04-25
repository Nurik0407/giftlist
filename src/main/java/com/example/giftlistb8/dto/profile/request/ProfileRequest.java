package com.example.giftlistb8.dto.profile.request;

import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ProfileRequest(
        String image,
        String country,
        LocalDate dateOfBirth,
        String phoneNumber,
        ClothingSize clothSize,
        ShoeSize shoeSize,
        String hobby,
        String important,
        String facebookLink,
        String instagramLink,
        String vkLink,
        String telegramLink
) {

}