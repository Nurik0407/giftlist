package com.example.giftlistb8.dto.charity.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CharityUpdateRequest(
        @NotBlank(message = "The id must not be empty.")
        @NotNull(message = "The id must not be empty.")
        Long id,
        @Size(min = 2, max = 30, message = "The name must contain between 2 and 30 characters.")
        @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+(([',. -][а-яА-ЯёЁa-zA-Z ])?[а-яА-ЯёЁa-zA-Z]*)*$", message = "The name must contain only letters.")
        @NotBlank(message = "The name must not be empty.")
        @NotNull(message = "The name must not be empty.")
        String name,
        @Size(min = 2, max = 20, message = "The state must contain between 2 and 30 characters.")
        @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+(([',. -][а-яА-ЯёЁa-zA-Z ])?[а-яА-ЯёЁa-zA-Z]*)*$", message = "The state must contain only letters.")
        @NotBlank(message = "The state must not be empty.")
        @NotNull(message = "The state must not be empty.")
        String state,
        @Size(min = 2, max = 30, message = "The category must contain between 2 and 40 characters.")
        @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+(([',. -][а-яА-ЯёЁa-zA-Z ])?[а-яА-ЯёЁa-zA-Z]*)*$", message = "The category must contain only letters.")
        @NotBlank(message = "The category must not be empty.")
        @NotNull(message = "The category must not be empty.")
        String category,
        @Size(min = 2, max = 40, message = "The subCategory must contain between 2 and 40 characters.")
        @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+(([',. -][а-яА-ЯёЁa-zA-Z ])?[а-яА-ЯёЁa-zA-Z]*)*$", message = "The subCategory must contain only letters.")
        @NotBlank(message = "The subCategory must not be empty.")
        @NotNull(message = "The subCategory must not be empty.")
        String subCategory,
        @Size(min = 2, max = 200, message = "The description must contain between 2 and 200 characters.")
        @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+(([',. -][а-яА-ЯёЁa-zA-Z ])?[а-яА-ЯёЁa-zA-Z]*)*$", message = "The description must contain only letters.")
        @NotBlank(message = "The description must not be empty.")
        @NotNull(message = "The description must not be empty.")
        String description,
        @NotBlank(message = "The image must not be empty.")
        @NotNull(message = "The image must not be empty.")
        String image
) {}
