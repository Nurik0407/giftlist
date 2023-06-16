package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.request.CharityRequest;
import com.example.giftlistb8.dto.charity.request.CharityUpdateRequest;
import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.dto.charity.response.GlobalSearchCharity;

import java.util.List;

public interface CharityService {

    SimpleResponse save(CharityRequest request);

    List<CharitiesResponse> findAll();

    SimpleResponse update(CharityUpdateRequest request);

    SimpleResponse delete(Long id);

    CharityResponse findById(Long id);

    List<GlobalSearchCharity> globalSearch(String keyWord);
}
