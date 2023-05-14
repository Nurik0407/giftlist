package com.example.giftlistb8.dto.profile.request;

import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import com.example.giftlistb8.validations.ValidName;
import com.example.giftlistb8.validations.ValidPhone;
import jakarta.validation.constraints.*;
import lombok.Builder;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Builder
public record ProfileRequest(

        @NotNull(message = "The image must not be empty.")
        String image,


        @ValidName(message = "The first name must contain between 2 and 30 characters,start with capital letter.")
        String firstName,


        @ValidName(message = "The last name must contain between 2 and 30 characters,start with capital letter.")
        String lastName,


        @ValidName(message = "The country name must be empty,start with capital letter.")
        String country,

        @Past(message = "The date of birth must be in the past.")
        LocalDate dateOfBirth,

        @NotNull(message = "The email must not be empty.")
        @Email(message = "The email is not valid.")
        String email,

        @ValidPhone
        String phoneNumber,

        @NotNull(message = "The clothing size must not be empty.")
        ClothingSize clothingSize,

        @NotNull(message = "The shoe size must not be empty.")
        ShoeSize shoeSize,

        @NotNull(message = "The hobby must not be empty.")
        String hobby,

        @NotNull(message = "The important field must not be empty.")
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
