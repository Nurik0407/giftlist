package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.dto.user.response.GlobalSearchFriend;
import com.example.giftlistb8.entities.Notification;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.enums.Type;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.FriendRepository;
import com.example.giftlistb8.repositories.NotificationRepository;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.FriendService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class FriendServiceImpl implements FriendService {

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final JwtService jwtService;
    private final NotificationRepository notificationRepository;

    @Override
    public List<FriendInfoResponse> getAllFriendsAndAllRequests(String type) {
        User user = jwtService.getUserInToken();
        log.info("Getting all {} for user {}", type, user.getEmail());
        if ("requests".equals(type)) {
            log.info("Found friend requests for user {}", user.getId());
            return friendRepository.getAllRequests(user.getId());
        } else {
            log.info("Found friend(s) for user {}", user.getEmail());
            return friendRepository.getAllFriends(user.getId());
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
        if (user.getFriends().contains(friend)) {
            user.getFriends().remove(friend);
            friend.getFriends().remove(user);
            log.info("User {} has deleted friend {}", user.getEmail(), friend.getEmail());
            return new SimpleResponse(HttpStatus.OK, "removed from friends");
        }
        if (friend.getRequestsForFriends().contains(user)) {
            friend.getRequestsForFriends().remove(user);
            log.info("User {} has declined friend request from {} ", user.getEmail(), friend.getEmail());
            return new SimpleResponse(HttpStatus.OK, "removed from friends");
        } else {
            friend.getRequestsForFriends().add(user);
            Notification notification = Notification.builder()
                    .type(Type.FRIEND_REQUEST)
                    .message("отправил(-а) вам запрос в друзья.")
                    .seen(false)
                    .toWhomUser(friend)
                    .fromWhomUser(user)
                    .createdAt(LocalDate.now())
                    .build();
            notificationRepository.save(notification);
            log.info("User {} has sent friend request to {}", user.getEmail(), friend.getEmail());
            return new SimpleResponse(HttpStatus.OK, "friend request");
        }
    }

    @Override
    public SimpleResponse acceptRequest(Long senderUserId) {
        User user = jwtService.getUserInToken();
        User request = userRepository.findById(senderUserId).orElseThrow(
                () -> new NotFoundException(
                        String.format("User with id: %s not found!", senderUserId)));

        if (user.getRequestsForFriends().contains(request)) {
            user.getFriends().add(request);
            request.getFriends().add(user);
            user.getRequestsForFriends().remove(request);

            Notification notification = Notification.builder()
                    .type(Type.ACCEPTED_THE_REQUEST)
                    .message("принял(-а) ваш запрос в друзья")
                    .seen(false)
                    .toWhomUser(request)
                    .fromWhomUser(user)
                    .createdAt(LocalDate.now())
                    .build();
            notificationRepository.save(notification);

            log.info("acceptRequest executed. Current user ID: {}, Sender user ID: {}, Result: FRIEND", user.getId(), senderUserId);
            return new SimpleResponse(HttpStatus.OK, "User with id %s is accepted as a friend".formatted(senderUserId));
        } else
            log.info("acceptRequest executed. Current user ID: {}, Sender user ID: {}, Result: not found request", user.getId(), senderUserId);
        throw new NotFoundException("User with id [%s] not found in your friend requests".formatted(senderUserId));
    }

    @Override
    public SimpleResponse rejectRequest(Long senderUserId) {
        User user = jwtService.getUserInToken();
        User sender = userRepository.findById(senderUserId).orElseThrow(() -> new NotFoundException(String.format("user with id: %s not found", senderUserId)));
        if (user.getRequestsForFriends().contains(sender)) {
            user.getRequestsForFriends().remove(sender);
            log.info("User {} rejected friend request from user {}", user.getEmail(), sender.getEmail());
            return SimpleResponse.builder()
                    .status(HttpStatus.OK)
                    .message("User with id [%s] is not accepted as a friend".formatted(senderUserId))
                    .build();
        } else {
            log.warn("User {} tried to reject friend request from user {} but no such request found", user.getEmail(), sender.getEmail());
            throw new NotFoundException("User with id [%s] not found in your friend requests".formatted(senderUserId));
        }
    }

    @Override
    public List<GlobalSearchFriend> search(String keyWord) {
        return friendRepository.globalSearch(keyWord);
    }
}


