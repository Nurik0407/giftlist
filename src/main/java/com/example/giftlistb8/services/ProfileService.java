package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.profile.request.ProfileRequest;
import com.example.giftlistb8.dto.profile.request.UpdateProfileRequest;
import com.example.giftlistb8.dto.profile.response.FriendsProfileResponse;
import com.example.giftlistb8.dto.profile.response.MyProfileResponse;
import com.example.giftlistb8.dto.profile.response.ProfileResponse;

public interface ProfileService {
    ProfileResponse saveProfile(ProfileRequest profileRequest);

    MyProfileResponse getMyProfile();

    ProfileResponse getMyFullProfile();

    FriendsProfileResponse getFriendsProfile(Long id);

    SimpleResponse saveUpdatedProfile(Long id, UpdateProfileRequest profileRequest);
}
