package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestCharity;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestWish;
import com.example.giftlistb8.dto.reserve.response.ReserveGetAllResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.reserve.response.ReserveSimpleResponse;

public interface ReserveService {
    ReserveSimpleResponse wishReserve(ReserveRequestWish reserveRequest);

    ReserveGetAllResponse getAllReserves();

    SimpleResponse addGiftToWish(Long wishId);

    ReserveSimpleResponse charityReserve(ReserveRequestCharity reserveRequestCharity);

    PaginationResponse getWishReservePagination(int page, int size);

    PaginationResponse getCharityReservePagination(int page, int size);

    SimpleResponse deleteCharity(Long userId,Long charityId);
    SimpleResponse deleteWish(Long userId,Long wishId);
}
