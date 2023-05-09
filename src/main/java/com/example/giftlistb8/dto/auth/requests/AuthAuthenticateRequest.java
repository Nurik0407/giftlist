package com.example.giftlistb8.dto.auth.requests;

import com.example.giftlistb8.validations.ValidPassword;
import jakarta.validation.constraints.Email;
import lombok.Builder;

@Builder
public record AuthAuthenticateRequest(
        @Email(message = "Sorry, the email address you entered is invalid. Please check if it is correct")
        String email,
        @ValidPassword
        String password
) {
}
