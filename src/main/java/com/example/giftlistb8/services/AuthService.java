package com.example.giftlistb8.services;


import com.example.giftlistb8.dto.auth.requests.AuthAuthenticateRequest;
import com.example.giftlistb8.dto.auth.requests.AuthRegisterRequest;
import com.example.giftlistb8.dto.auth.responses.AuthRegisterResponse;

public interface AuthService {
    AuthRegisterResponse authenticate(AuthAuthenticateRequest authRequest);

    AuthRegisterResponse register(AuthRegisterRequest userRequest);
}
