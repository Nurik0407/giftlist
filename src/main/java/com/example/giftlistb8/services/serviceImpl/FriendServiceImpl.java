package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.FriendRepository;
import com.example.giftlistb8.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FriendServiceImpl {

        private final UserRepository userRepository;
        private final FriendRepository friendRepository;
        private final JwtService jwtService;

        public List<FriendInfoResponse> getAllFriends() {
            User user = jwtService.getUserInToken();
            return friendRepository.getAllFriends(user.getEmail());
        }

        public List<FriendInfoResponse> getAllRequests() {
            User user = getAuthPrincipal();
            return friendRepository.getAllRequests(user.getEmail());
        }

        @Transactional
        public SimpleResponse sendRequestToFriend(Long friendId) {
            User user = getAuthPrincipal();
            User friend = userRepository.findById(friendId).orElseThrow(
                    () -> new NotFoundException(String.format("user with id %s not found", friendId)));
            if (user.equals(friend)){
                throw new BadRequestException("you can't send request to yourself");
            }
            if (friend.getRequests().contains(user)) {
                throw new BadRequestException("you have already submitted a request!");
            }
            else if (user.getFriends().contains(friend)) {
                throw new BadRequestException("you have already submitted a request,because you are friends!");
            }
            friend.setRequests(List.of(user));
            return new SimpleResponse("successful", "REQUEST TO FRIEND");
        }

        @Transactional
        public SimpleResponse acceptRequest(Long senderUserId) {
            User user = getAuthPrincipal();
            User request = userRepository.findById(senderUserId).orElseThrow(
                    () -> new NotFoundException(String.format("User with id: %s not found!", senderUserId)));
            if (user.getRequests().contains(request)) {
                user.setFriends(List.of(request));
                user.getRequests().remove(request);
            }
            else
                return new SimpleResponse("request not found","");

            return new SimpleResponse("successful", "FRIEND");
        }

        @Transactional
        public SimpleResponse rejectRequest(Long senderUserId) {
            User user = getAuthPrincipal();
            User sender = userRepository.findById(senderUserId).orElseThrow(
                    () -> new NotFoundException(String.format("user with id: %s not found", senderUserId)));
            if (user.getRequests().contains(sender)) {
                user.getRequests().remove(sender);
            }
            else
                return new SimpleResponse("request not found","");

            return new SimpleResponse("successful", "NOT FRIEND");
        }

        @Transactional
        public SimpleResponse deleteFromFriends(Long friendId) {
            User user = getAuthPrincipal();
            User friend = userRepository.findById(friendId).orElseThrow(
                    () -> new NotFoundException(String.format("user with id: %s not found", friendId)));
            if (user.getFriends().contains(friend)) {
                user.getFriends().remove(friend);
            }
            else
                return new SimpleResponse("friend not found","");

            return new SimpleResponse("successful", "NOT FRIEND");
        }

        @Transactional
        public SimpleResponse cancelRequestToFriend(Long friendId) {
            User user = getAuthPrincipal();
            User friend = userRepository.findById(friendId).orElseThrow(
                    () -> new NotFoundException(String.format("user with id %s not found", friendId)));
            if (user.getRequests().contains(friend)) {
                user.getRequests().remove(friend);
            }
            else
                return new SimpleResponse("request not found","");

            return new SimpleResponse("successful", "NOT FRIEND");
        }

    }

}
