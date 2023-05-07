package com.example.giftlistb8.dto.profile.response;

import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ProfileResponse(
        Long id,
        String image,
        String fullName,
        String country,
        String email,
        String hobby,
        LocalDate dateOfBirth,
        String phoneNumber,
        String important,
        ClothingSize clothingSize,
        ShoeSize shoeSize,
        String faceBook,
        String instagram,
        String telegram,
        String whatsApp

) {
}
