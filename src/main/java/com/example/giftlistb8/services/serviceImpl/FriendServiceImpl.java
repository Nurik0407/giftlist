package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.FriendRepository;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.FriendService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService {

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final JwtService jwtService;

    @Transactional
    public List<FriendInfoResponse> getAllFriendsAndAllRequests(String type) {
        User user = jwtService.getUserInToken();
        if ("requests".equals(type)) {
            return friendRepository.getAllRequests(user.getEmail());
        } else {
            return friendRepository.getAllFriends(user.getEmail());
        }
    }

    @Transactional
    public SimpleResponse sendAndDelete(Long friendId) {
        User user = jwtService.getUserInToken();
        User friend = userRepository.findById(friendId).orElseThrow(() -> new NotFoundException(String.format("user with id %s not found", friendId)));
        if (user.equals(friend)) {
            throw new BadRequestException("You cannot send a request to yourself!");
        }
        if (friend.getRequestsForFriends().contains(user)) {
            friend.getRequestsForFriends().remove(user);
            return new SimpleResponse(HttpStatus.OK, "not friend");
        }
        if (friend.getFriends().contains(user)) {
            friend.getFriends().remove(user);
            return new SimpleResponse(HttpStatus.OK, "not friends");
        } else {
            friend.getRequestsForFriends().add(user);
            return new SimpleResponse(HttpStatus.OK, "friend request");
        }
    }

    @Transactional
    public SimpleResponse acceptRequest(Long senderUserId) {
        User user = jwtService.getUserInToken();
        User request = userRepository.findById(senderUserId).orElseThrow(() -> new NotFoundException(String.format("User with id: %s not found!", senderUserId)));
        if (user.getRequestsForFriends().contains(request)) {
            user.getFriends().add(request);
            user.getRequestsForFriends().remove(request);

        } else return new SimpleResponse(HttpStatus.NOT_FOUND, "not found request");

        return new SimpleResponse(HttpStatus.OK, "FRIEND");
    }

    @Transactional
    public SimpleResponse rejectRequest(Long senderUserId) {
        User user = jwtService.getUserInToken();
        User sender = userRepository.findById(senderUserId).orElseThrow(() -> new NotFoundException(String.format("user with id: %s not found", senderUserId)));
        if (user.getRequestsForFriends().contains(sender)) {
            user.getRequestsForFriends().remove(sender);
        } else return new SimpleResponse(HttpStatus.NOT_FOUND, " not found request");

        return new SimpleResponse(HttpStatus.OK, "NOT FRIEND");
    }

    @Transactional
    public SimpleResponse cancelRequestToFriend(Long friendId) {
        User user = jwtService.getUserInToken();
        User friend = userRepository.findById(friendId).orElseThrow(() -> new NotFoundException(String.format("user with id %s not found", friendId)));
        if (friend.getRequestsForFriends().contains(user)) {
            friend.getRequestsForFriends().remove(user);
        } else return new SimpleResponse(HttpStatus.NOT_FOUND, "request not found");

        return new SimpleResponse(HttpStatus.OK, "NOT FRIEND");
    }

}


