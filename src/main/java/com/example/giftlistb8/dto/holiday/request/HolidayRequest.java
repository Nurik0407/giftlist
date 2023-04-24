package com.example.giftlistb8.dto.holiday.request;

import java.time.LocalDate;

public record HolidayRequest(
        String name,
        String image,
        LocalDate dateOfHoliday
) {}
