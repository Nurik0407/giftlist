package com.example.giftlistb8.dto.user.response;

import com.example.giftlistb8.dto.charity.response.CharityResponseUser;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseUser;
import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseGetById {
    private Long id;
    private String fullName;
    private String image;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String country;
    private String hobby;
    private String important;
    private ClothingSize clothingSize;
    private ShoeSize shoeSize;
    private String instagram;
    private String telegram;
    private String facebook;
    private String whatsApp;
    private String email;
    boolean inFriends;
    boolean inRequests;
    List<WishResponseUser> wishResponseUserList;
    List<HolidayResponse>holidayResponses;
    List<CharityResponseUser>charityResponseUsers;
}
