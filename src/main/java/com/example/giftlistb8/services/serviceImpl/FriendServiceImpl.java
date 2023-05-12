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
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class FriendServiceImpl implements FriendService {

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final JwtService jwtService;

    @Override
    public List<FriendInfoResponse> getAllFriendsAndAllRequests(String type) {
        User user = jwtService.getUserInToken();
        log.info("Getting all {} for user {}", type, user.getEmail());
        if ("requests".equals(type)) {
            log.info("Found friend requests for user {}", user.getEmail());
            return friendRepository.getAllRequests(user.getEmail());
        } else {
            log.info("Found friend(s) for user {}", user.getEmail());
            return friendRepository.getAllFriends(user.getEmail());
        }
    }

    @Override
    public SimpleResponse sendAndDelete(Long friendId) {
        User user = jwtService.getUserInToken();
        User friend = userRepository.findById(friendId).orElseThrow(() -> new NotFoundException(String.format("user with id %s not found", friendId)));
        log.info("Sending friend request or deleting friend for user {} and friend {} ", user.getEmail(), friend.getEmail());
        if (user.equals(friend)) {
            throw new BadRequestException("You cannot send a request to yourself!");
        }
        if (friend.getRequestsForFriends().contains(user)) {
            friend.getRequestsForFriends().remove(user);
            log.info("User {} has declined friend request from {} ", user.getEmail(), friend.getEmail());
            return new SimpleResponse(HttpStatus.OK, "removed from friends");
        }
        if (friend.getFriends().contains(user)) {
            friend.getFriends().remove(user);
            log.info("User {} has deleted friend {}", user.getEmail(), friend.getEmail());
            return new SimpleResponse(HttpStatus.OK, "removed from friends");
        } else {
            friend.getRequestsForFriends().add(user);
            log.info("User {} has sent friend request to {}", user.getEmail(), friend.getEmail());
            return new SimpleResponse(HttpStatus.OK, "friend request");
        }
    }

    @Override
    public SimpleResponse acceptRequest(Long senderUserId) {
        User user = jwtService.getUserInToken();
        User request = userRepository.findById(senderUserId).orElseThrow(() -> new NotFoundException(String.format("User with id: %s not found!", senderUserId)));
        if (user.getRequestsForFriends().contains(request)) {
            user.getFriends().add(request);
            user.getRequestsForFriends().remove(request);
            log.info("acceptRequest executed. Current user ID: {}, Sender user ID: {}, Result: FRIEND", user.getId(), senderUserId);
            return new SimpleResponse(HttpStatus.OK, "FRIEND");
        } else
            log.info("acceptRequest executed. Current user ID: {}, Sender user ID: {}, Result: not found request", user.getId(), senderUserId);
        return new SimpleResponse(HttpStatus.NOT_FOUND, "not found request");
    }

    @Override
    public SimpleResponse rejectRequest(Long senderUserId) {
        User user = jwtService.getUserInToken();
        User sender = userRepository.findById(senderUserId).orElseThrow(() -> new NotFoundException(String.format("user with id: %s not found", senderUserId)));
        if (user.getRequestsForFriends().contains(sender)) {
            user.getRequestsForFriends().remove(sender);
            log.info("User {} rejected friend request from user {}", user.getEmail(), sender.getEmail());
        } else {
            log.warn("User {} tried to reject friend request from user {} but no such request found", user.getEmail(), sender.getEmail());
            return new SimpleResponse(HttpStatus.NOT_FOUND, " not found request");
        }
        return new SimpleResponse(HttpStatus.OK, "not friend");
    }
}


