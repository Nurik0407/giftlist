package com.example.giftlistb8.dto.holiday.request;

import com.example.giftlistb8.validations.ValidName;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record HolidayRequest(
        @ValidName(message = "Name must contain at least 2 characters and have both upper and lower case letters")
        String name,
        @NotBlank(message = "Please upload a photo.")
        @NotNull(message = "Please upload a photo.")
        String image,
        @NotNull(message = "Please select a holiday date.")
        @Future(message = "Holiday date must be in the future")
        LocalDate dateOfHoliday
) {
}
