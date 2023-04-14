package com.example.giftlistb8.dto.auth.requests;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record AuthAuthenticateRequest(
        @Email(message = "Sorry, the email address you entered is invalid. Please check if it is correct")
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least one letter in , one number and be at least 8 characters long.")
        String password
) { }
