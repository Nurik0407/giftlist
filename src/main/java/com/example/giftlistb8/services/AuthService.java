package com.example.giftlistb8.services;


import com.example.giftlistb8.dto.auth.requests.AuthAuthenticateRequest;
import com.example.giftlistb8.dto.auth.requests.AuthRegisterRequest;
import com.example.giftlistb8.dto.auth.responses.AuthRegisterResponse;
import com.google.firebase.auth.FirebaseAuthException;

public interface AuthService {
    AuthRegisterResponse authenticate(AuthAuthenticateRequest authRequest);

    AuthRegisterResponse register(AuthRegisterRequest userRequest);

    AuthRegisterResponse authWithGoogle(String tokenId) throws FirebaseAuthException;
}
