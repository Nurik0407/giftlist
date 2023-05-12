package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.repositories.custom.CustomUserRepository;
import com.example.giftlistb8.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final CustomUserRepository customUserRepository;
    private final UserRepository userRepository;

    @Override
    public PaginationResponse<UserResponseGetAll> getAllUsers(int size, int page) {
        log.info("Getting all users");
        return customUserRepository.getAllUsers(size, page);
    }

    @Override
    public UserResponseGetById getById(Long userId) {
        log.info("Getting user by id: {}", userId);
        return customUserRepository.getById(userId);
    }

    @Override
    public SimpleResponse deleteById(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with %s id not found", userId)));
        log.info("Deleted user by id: {}", userId);
        return customUserRepository.deleteById(userId);
    }

    @Override
    public SimpleResponse updateBlockedStatus(Long userId, boolean blocked) {
        log.info("Updating blocked status of user with id: {}", userId);
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setIsBlocked(true);
            userRepository.save(user);
            log.info("Successfully updated blocked status of user with id: {}", userId);
        }
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("User with id %s successfully blocked", userId)).build();
    }
}


