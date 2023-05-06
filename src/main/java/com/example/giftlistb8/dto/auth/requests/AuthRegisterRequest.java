package com.example.giftlistb8.dto.auth.requests;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record AuthRegisterRequest(
        @Size(min = 2, max = 30, message = "The name must contain between 2 and 30 characters.")
        @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+(([',. -][а-яА-ЯёЁa-zA-Z ])?[а-яА-ЯёЁa-zA-Z]*)*$", message = "The name must contain only letters.")
        @NotBlank(message = "The name must not be empty.")
        @NotNull(message = "The name must not be empty.")
        String firstName,
        @Size(min = 2, max = 30, message = "The surname must contain between 2 and 30 characters.")
        @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+(([',. -][а-яА-ЯёЁa-zA-Z ])?[а-яА-ЯёЁa-zA-Z]*)*$", message = "The surname must contain only letters.")
        @NotBlank(message = "The surname must not be empty.")
        @NotNull(message = "The surname must not be empty.")
        String lastName,
        @Email(message = "Sorry, the email address you entered is invalid. Please check if it is correct")
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least one letter in , one number and be at least 8 characters long.")
        String password,
        boolean subscribeMailing
) { }



