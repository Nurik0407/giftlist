package com.example.giftlistb8.dto.charity.request;

import com.example.giftlistb8.validations.ValidName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CharityRequest(
        @ValidName(message = "Name must contain at least 2 characters and have both upper and lower case letters")
        String name,
        @Size(min = 2, max = 20, message = "The state must contain between 2 and 30 characters.")
        @NotBlank(message = "The state must not be empty.")
        @NotNull(message = "The state must not be empty.")
        String state,
        @Size(min = 2, max = 30, message = "The category must contain between 2 and 40 characters.")
        @NotNull(message = "The category must not be empty.")
        String category,
        @Size(min = 2, max = 40, message = "The subCategory must contain between 2 and 40 characters.")
        @NotNull(message = "The subCategory must not be empty.")
        String subCategory,
        @Size(min = 2, max = 255, message = "The description must contain between 2 and 255 characters.")
        @NotNull(message = "The description must not be empty.")
        String description,
        @NotBlank(message = "The image must not be empty.")
        @NotNull(message = "The image must not be empty.")
        String image
) {
}
