package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.auth.requests.AuthAuthenticateRequest;
import com.example.giftlistb8.dto.auth.requests.AuthRegisterRequest;
import com.example.giftlistb8.dto.auth.responses.AuthRegisterResponse;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.enums.Role;
import com.example.giftlistb8.exceptions.AlreadyExistsException;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.AuthService;
import jakarta.transaction.Transactional;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;


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
                .subscribeMailing(userRequest.subscribeMailing())
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);

        log.info("User registered successfully with email {}", userRequest.email());

        return AuthRegisterResponse.builder()
                .id(user.getId())
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
            log.error("Invalid email or password for email {}", userRegisterRequest.email());
            throw new BadCredentialsException("Invalid email or password.");
        }

        log.info("User authenticated successfully with email {}", userRegisterRequest.email());

        String token = jwtService.generateToken(user);

        return AuthRegisterResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole().name())
                .token(token)
                .build();
    }

//    @PostConstruct
//    void init() throws IOException {
//
//        FileInputStream serviceAccount =
//                new FileInputStream("giftlist-b8.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }
//
//
//    @Override
//    public AuthRegisterResponse authWithGoogle(String tokenId) throws FirebaseAuthException {
//        FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(tokenId);
//        if (!userRepository.existsByEmail(firebaseToken.getEmail())) {
//            User newUser = new User();
//            String[] name = firebaseToken.getName().split(" ");
//            newUser.setFirstName(name[0]);
//            newUser.setLastName(name[1]);
//            newUser.setEmail(firebaseToken.getEmail());
//            newUser.setPassword(firebaseToken.getEmail());
//            newUser.setRole(Role.USER);
//            newUser.setSubscribeMailing(true);
//            userRepository.save(newUser);
//        }
//
//        User user = userRepository.findByEmail(firebaseToken.getEmail()).orElseThrow(() -> {
//            log.error("User not found for email {}", firebaseToken.getEmail());
//            throw new NotFoundException(String.format("User with this %s email not found!!", firebaseToken.getEmail()));
//        });
//
//        log.info("User authenticated successfully with Google for email {}", firebaseToken.getEmail());
//
//        String token = jwtService.generateToken(user);
//
//        return AuthRegisterResponse.builder()
//                .email(firebaseToken.getEmail())
//                .token(token)
//                .build();
//    }
}
