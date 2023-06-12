package com.example.giftlistb8.repositories.custom;

import com.example.giftlistb8.dto.holiday.response.HolidayByIdResponse;

public interface HolidayRepositoryCustom {
    HolidayByIdResponse getById(Long id);
}
