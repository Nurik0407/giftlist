package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.feed.response.FeedResponse;
import com.example.giftlistb8.dto.feed.response.PaginationResponse;

public interface FeedService {
     PaginationResponse<FeedResponse> getAll(int page, int size);

     FeedResponse getById(Long wishId);
}
