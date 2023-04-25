package com.example.giftlistb8.dto.profile.response;

import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import com.example.giftlistb8.enums.Status;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
@Builder
public record FriendsProfileResponse(
        Long id,
        String image,
        Status status,
        String firstName,
        String lastName,
        String country,
        LocalDate dateOfBirth,
        String email,
        String phoneNumber,
        ClothingSize clothSize,
        ShoeSize shoeSize,
        String hobby,
        String important,
        String facebookLink,
        String instagramLink,
        String vkLink,
        String telegramLink,
        Boolean isBlock,
        Boolean sendRequest,
        List<HolidayResponse> friendsHolidays

//     List<WishResponse> friendsWishes,
//     List<CharityResponse> friendsCharities
) {
}
