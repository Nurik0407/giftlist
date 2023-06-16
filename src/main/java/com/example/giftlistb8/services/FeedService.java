package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.feed.response.FeedResponse;
import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.feed.response.FeedResponseGetById;

public interface FeedService {
     PaginationResponse<FeedResponse> getAll(int page, int size,String keyWord);

     FeedResponseGetById getById(Long wishId);
}
