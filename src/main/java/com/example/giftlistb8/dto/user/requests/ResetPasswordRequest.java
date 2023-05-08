package com.example.giftlistb8.dto.user.requests;

import com.example.giftlistb8.annotation.PasswordMatches;
import com.example.giftlistb8.validations.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class ResetPasswordRequest {
    @ValidPassword
    private String password;
    @ValidPassword
    private String confirmPassword;
}
