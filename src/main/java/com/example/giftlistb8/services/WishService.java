package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.wish.requests.WishRequest;
import com.example.giftlistb8.dto.wish.responses.WishResponse;

import java.util.List;

public interface WishService {
    List<WishResponse> findAll();
    WishResponse getById(Long id);
    SimpleResponse save(WishRequest request);
    SimpleResponse delete(Long id);
    SimpleResponse update(Long id, WishRequest request);

}
