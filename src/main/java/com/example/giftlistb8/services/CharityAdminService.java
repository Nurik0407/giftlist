package com.example.giftlistb8.services;


import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.request.CharityRequest;
import com.example.giftlistb8.dto.charity.request.CharityUpdateRequest;
import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;

import java.util.List;

public interface CharityAdminService {
    List<CharitiesResponse> findAll();

    SimpleResponse delete(Long id);

    SimpleResponse save(CharityRequest request);

    SimpleResponse update(CharityUpdateRequest request);

    CharityResponse findById(Long id);
}
