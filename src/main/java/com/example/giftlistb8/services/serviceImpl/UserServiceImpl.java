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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final CustomUserRepository customUserRepository;
    private final UserRepository userRepository;

    @Override
    public PaginationResponse<UserResponseGetAll> getAllUsers(int size, int page) {
        return customUserRepository.getAllUsers(size, page);
    }

    @Override
    public UserResponseGetById getById(Long userId) {
        return customUserRepository.getById(userId);
    }

    @Override
    public SimpleResponse deleteById(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException(String.format("User with %s id not found", userId)));
        return customUserRepository.deleteById(userId);
    }

    @Override
    public SimpleResponse updateBlockedStatus(Long userId, boolean blocked) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setIsBlocked(true);
            userRepository.save(user);
        }
        return SimpleResponse.builder().status(HttpStatus.OK).message(String.format("Successfully blocked", userId)).build();
    }
}


