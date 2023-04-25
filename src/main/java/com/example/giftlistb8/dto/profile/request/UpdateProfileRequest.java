package com.example.giftlistb8.dto.profile.request;

import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UpdateProfileRequest(

        String image,
        String firstName,
        String lastName,
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
