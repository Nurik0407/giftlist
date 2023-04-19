package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.auth.requests.AuthAuthenticateRequest;
import com.example.giftlistb8.dto.auth.requests.AuthRegisterRequest;
import com.example.giftlistb8.dto.auth.responses.AuthRegisterResponse;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.enums.Role;
import com.example.giftlistb8.exceptions.AlreadyExistsException;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthRegisterResponse register(AuthRegisterRequest userRequest) {
        if (userRepository.existsByEmail(userRequest.email())) {
            throw new AlreadyExistsException("Sorry, this email is already registered. Please try a different email or login to your existing account");
        }
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
                .email(user.getEmail())
                .role(user.getRole().name())
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthRegisterResponse authenticate(AuthAuthenticateRequest userRegisterRequest) {
        User user = userRepository.findByEmail(userRegisterRequest.email())
                .orElseThrow(() ->
                        new BadRequestException("Invalid email or password."));
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userRegisterRequest.email(),
                            userRegisterRequest.password()
                    )
            );
        } catch (AuthenticationException e) {
            log.error("Invalid email or password");
            throw new BadCredentialsException("Invalid email or password.");
        }
        String token = jwtService.generateToken(user);

        return AuthRegisterResponse.builder()
                .email(user.getEmail())
                .role(user.getRole().name())
                .token(token)
                .build();
    }
}
