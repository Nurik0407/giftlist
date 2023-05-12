package com.example.giftlistb8.dto.charity.response;

import com.example.giftlistb8.dto.user.response.UserResponseGetById;
import com.example.giftlistb8.dto.user.response.WhoComplaintResponse;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record CharityResponseProfile(
        Long id,
        String fullName,
        String userImage,
        String phoneNumber,
        String charityName,
        String description,
        String category,
        String subCategory,
        String state,
        LocalDate dateAdded,
        String image,
        boolean isReserved,
        boolean isAnonymous,
        List<WhoComplaintResponse> whoComplaintResponses
) {
}
