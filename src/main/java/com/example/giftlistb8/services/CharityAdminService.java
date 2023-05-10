package com.example.giftlistb8.services;


import com.example.giftlistb8.dto.charity.response.CharitiesResponse;

import java.util.List;

public interface CharityAdminService {
    List<CharitiesResponse> findAll();
}
