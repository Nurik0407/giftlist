package com.example.giftlistb8.dto.holiday.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record HolidayRequest(
        @Size(min = 2, max = 30, message = "The name must contain between 2 and 30 characters.")
        @Pattern(regexp = "^[а-яА-ЯёЁa-zA-Z]+(([',. -][а-яА-ЯёЁa-zA-Z ])?[а-яА-ЯёЁa-zA-Z]*)*$", message = "The name must contain only letters.")
        @NotBlank(message = "The name must not be empty.")
        @NotNull(message = "The name must not be empty.")
        String name,
        @NotBlank(message = "Please upload a photo.")
        @NotNull(message = "Please upload a photo.")
        String image,
        @NotNull(message = "Please select a holiday date.")
        @Future(message = "Holiday date must be in the future")
        LocalDate dateOfHoliday
) {
}
