package com.example.giftlistb8.repositories.custom;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;

public interface CustomUserRepository {
    PaginationResponse<UserResponseGetAll>getAllUsers(int size ,int page);
    UserResponseGetById getById(Long userId);
    SimpleResponse deleteById(Long userId);

}
