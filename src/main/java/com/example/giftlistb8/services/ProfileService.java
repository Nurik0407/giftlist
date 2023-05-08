package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.profile.request.ChangePasswordUser;
import com.example.giftlistb8.dto.profile.request.ProfileRequest;
import com.example.giftlistb8.dto.profile.request.ProfileUpdateRequest;
import com.example.giftlistb8.dto.profile.response.ProfileResponse;
import com.example.giftlistb8.dto.profile.response.ProfileResponseGetById;

public interface ProfileService {
    SimpleResponse saveUser(ProfileRequest profileRequest);
    ProfileResponseGetById getById();
    ProfileResponse getByIdDetailInformation();
    SimpleResponse changeUserPassword(ChangePasswordUser changePasswordUser);
    SimpleResponse updateUserProfile(ProfileUpdateRequest profileUpdateRequest);

}
