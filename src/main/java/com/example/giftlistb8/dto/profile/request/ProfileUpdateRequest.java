package com.example.giftlistb8.dto.profile.request;

import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import com.example.giftlistb8.validations.ValidName;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

public record ProfileUpdateRequest(
        @NotBlank(message = "The id must not be empty.")
        @NotNull(message = "The id must not be empty.")
        Long id,
        @NotBlank(message = "The image must not be empty.")
        @NotNull(message = "The image must not be empty.")
        String image,

        @NotBlank(message = "The first name must not be empty.")
        @ValidName(message = "The first name contains invalid characters.")
        String firstName,

        @NotBlank(message = "The last name must not be empty.")
        @ValidName(message = "The last name contains invalid characters.")
        String lastName,

        @NotBlank(message = "The country must not be empty.")
        @NotNull(message = "The country must not be empty.")
        String country,

        @Past(message = "The date of birth must be in the past.")
        LocalDate dateOfBirth,

        @NotBlank(message = "The email must not be empty.")
        @Email(message = "The email is not valid.")
        String email,

        @NotBlank(message = "The phone number must not be empty.")
        @Pattern(regexp = "\\d{10}", message = "The phone number must contain 10 digits.")
        String phoneNumber,

        @NotNull(message = "The clothing size must not be empty.")
        ClothingSize clothingSize,

        @NotNull(message = "The shoe size must not be empty.")
        ShoeSize shoeSize,

        @NotBlank(message = "The hobby must not be empty.")
        String hobby,

        @NotBlank(message = "The important field must not be empty.")
        String important,

        @URL(message = "The Facebook URL is not valid.")
        String faceBook,

        @URL(message = "The WhatsApp URL is not valid.")
        String whatsApp,

        @URL(message = "The Instagram URL is not valid.")
        String instagram,

        @URL(message = "The Telegram URL is not valid.")
        String telegram
) {
}
