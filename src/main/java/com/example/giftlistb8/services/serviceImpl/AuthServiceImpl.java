package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.auth.requests.AuthAuthenticateRequest;
import com.example.giftlistb8.dto.auth.requests.AuthRegisterRequest;
import com.example.giftlistb8.dto.auth.responses.AuthRegisterResponse;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.enums.Role;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthRegisterResponse register(AuthRegisterRequest userRequest) {
        var user = User.builder()
                .firstName(userRequest.firstName())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .password(passwordEncoder.encode(userRequest.password()))
                .isBlocked(false)
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        return AuthRegisterResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthRegisterResponse authenticate(AuthAuthenticateRequest userRegisterRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRegisterRequest.email(),
                        userRegisterRequest.password()
                )
        );
        User user = userRepository.findByEmail(userRegisterRequest.email())
                .orElseThrow(() -> new NoSuchElementException(String.format
                        ("User with email: %s doesn't exists", userRegisterRequest.email())));
        String token = jwtService.generateToken(user);

        return AuthRegisterResponse.builder()
                .token(token)
                .build();
    }
}
