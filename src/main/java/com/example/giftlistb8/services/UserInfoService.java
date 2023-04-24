package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.auth.SimpleResponse;

public interface UserInfoService {
    SimpleResponse updateResetPasswordToken(String email);
    SimpleResponse getByResetPasswordToken(String token, String password, String secondPassword);

}
