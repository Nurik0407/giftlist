package com.example.giftlistb8.dto.user.response;

import com.example.giftlistb8.dto.charity.response.CharityResponseUser;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseUser;
import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.A;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseGetById {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String image;
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
    List<WishResponseUser> wishResponseUserList;
    List<HolidayResponse>holidayResponses;
    List<CharityResponseUser>charityResponseUsers;

}
