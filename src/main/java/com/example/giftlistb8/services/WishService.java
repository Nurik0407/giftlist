package com.example.giftlistb8.services;

import com.example.giftlistb8.config.SimpleResponse;
import com.example.giftlistb8.dto.wish.requests.WishRequest;
import com.example.giftlistb8.dto.wish.responses.WishResponce;

import java.util.List;

public interface WishService {
    List<WishResponce> findAll();
    WishResponce getById(Long id);
    SimpleResponse save(WishRequest request);
    SimpleResponse delete(Long id);
    SimpleResponse update(Long id, WishRequest request);

}
