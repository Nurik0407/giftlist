package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;

public interface UserInfoService {
    SimpleResponse updateResetPasswordToken(String email,String link);
    SimpleResponse getByResetPasswordToken(String token, String password, String secondPassword);

}
