package com.example.giftlistb8.dto.profile.response;

import com.example.giftlistb8.enums.ClothingSize;
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
        String shoeSize,
        String faceBook,
        String instagram,
        String telegram,
        String whatsApp

) {
    public ProfileResponse(Long id, String image, String fullName, String country, String email, String hobby, LocalDate dateOfBirth, String phoneNumber, String important, ClothingSize clothingSize, String shoeSize, String faceBook, String instagram, String telegram, String whatsApp) {
        this.id = id;
        this.image = image;
        this.fullName = fullName;
        this.country = country;
        this.email = email;
        this.hobby = hobby;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.important = important;
        this.clothingSize = clothingSize;
        this.shoeSize = shoeSize;
        this.faceBook = faceBook;
        this.instagram = instagram;
        this.telegram = telegram;
        this.whatsApp = whatsApp;
    }
}
