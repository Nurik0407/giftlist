package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;

import java.util.List;

public interface FriendService {

  List<FriendInfoResponse> getAllFriends();
    List<FriendInfoResponse> getAllRequests();
    SimpleResponse sendRequestToFriend(Long friendId);
    SimpleResponse acceptRequest(Long senderUserId);
    SimpleResponse rejectRequest(Long senderUserId);
    SimpleResponse deleteFromFriends(Long friendId);
    SimpleResponse cancelRequestToFriend(Long friendId);

}
