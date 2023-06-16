package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.dto.user.response.GlobalSearchFriend;

import java.util.List;

public interface FriendService {

    List<FriendInfoResponse> getAllFriendsAndAllRequests(String type);

    SimpleResponse sendAndDelete(Long friendId);

    SimpleResponse acceptRequest(Long senderUserId);

    SimpleResponse rejectRequest(Long senderUserId);

    List<GlobalSearchFriend> search(String keyWord);
}
