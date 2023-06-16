package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.user.requests.UpdateBlockStatus;
import com.example.giftlistb8.dto.user.response.GlobalSearchFriend;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;

import java.util.List;

public interface UserService {
    PaginationResponse<UserResponseGetAll> getAllUsers(int size, int page);

    UserResponseGetById getById(Long userId);

    SimpleResponse deleteById(Long userId);

    SimpleResponse updateBlockedStatus(UpdateBlockStatus updateBlockStatus);

    List<GlobalSearchFriend> search(String keyWord);
}
