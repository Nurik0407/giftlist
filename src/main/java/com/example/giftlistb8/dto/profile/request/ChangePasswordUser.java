package com.example.giftlistb8.dto.profile.request;

import com.example.giftlistb8.validations.ValidPassword;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ChangePasswordUser(

        @NotNull(message = "The id must not be empty.")
        Long id,
        @ValidPassword
        String oldPassword,
        @ValidPassword
        String newPassword,
        @ValidPassword
        String repeatPassword
) {
}
