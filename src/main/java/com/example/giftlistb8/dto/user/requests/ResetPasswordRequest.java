package com.example.giftlistb8.dto.user.requests;

import com.example.giftlistb8.annotation.PasswordMatches;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class ResetPasswordRequest {
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$", message = "The password must contain at least one letter in , one number and be at least 8 characters long.")
    private String password;
    private String confirmPassword;
}
