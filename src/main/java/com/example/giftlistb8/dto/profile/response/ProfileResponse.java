package com.example.giftlistb8.dto.profile.response;

import com.example.giftlistb8.enums.ClothingSize;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ProfileResponse(
        Long id,
        String image,
        String lastName,
        String firstName,
        String country,
        String email,
        String hobby,
        LocalDate dateOfBirth,
        String phoneNumber,
        String important,
        ClothingSize clothingSize,
        String shoeSize,
        String faceBook,
        String instagram,
        String telegram,
        String whatsApp

) {}
