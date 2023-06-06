package com.example.giftlistb8.dto.holiday.response;

import com.example.giftlistb8.dto.wish.responses.WishResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record HolidayByIdResponse(
        Long holidayId,
        String holidayName,
        List<WishResponse> wishes
        ) {
}
