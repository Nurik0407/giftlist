package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.user.requests.UpdateBlockStatus;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;

public interface UserService {
    PaginationResponse<UserResponseGetAll> getAllUsers(int size, int page);

    UserResponseGetById getById(Long userId);

    SimpleResponse deleteById(Long userId);

    SimpleResponse updateBlockedStatus(UpdateBlockStatus updateBlockStatus);
}
