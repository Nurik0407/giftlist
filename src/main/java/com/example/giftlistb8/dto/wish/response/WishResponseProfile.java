package com.example.giftlistb8.dto.wish.response;

import com.example.giftlistb8.dto.user.response.WhoComplaintResponse;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record WishResponseProfile(
        Long id,
        String fullName,
        String userImage,
        String phoneNumber,
        String wishName,
        String description,
        LocalDate date,
        String holidayName,
        String status,
        String wishImage,
        boolean isReserved,
        boolean isAnonymous,
        List<WhoComplaintResponse> whoComplaintResponses
) {
}
