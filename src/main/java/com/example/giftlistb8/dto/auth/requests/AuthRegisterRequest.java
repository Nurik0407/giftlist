package com.example.giftlistb8.dto.auth.requests;

import com.example.giftlistb8.validations.ValidName;
import com.example.giftlistb8.validations.ValidPassword;
import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record AuthRegisterRequest(
        @ValidName(message = "The first name must contain between 2 and 30 characters,start with capital letter.")
        String firstName,
        @ValidName(message = "The last name must contain between 2 and 30 characters,start with capital letter.")
        String lastName,
        @Email(message = "Sorry, the email address you entered is invalid. Please check if it is correct")
        String email,
        @ValidPassword
        String password
) { }



