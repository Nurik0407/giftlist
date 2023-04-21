package com.example.giftlistb8.services;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestCharity;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestWish;
import com.example.giftlistb8.dto.reserve.response.PaginationResponseCharity;
import com.example.giftlistb8.dto.reserve.response.PaginationResponseWish;
import com.example.giftlistb8.dto.reserve.response.ReserveGetAllResponse;
import com.example.giftlistb8.dto.SimpleResponse;

public interface ReserveService {
    SimpleResponse wishReserve(ReserveRequestWish reserveRequest);
    ReserveGetAllResponse getAllReserves();
    SimpleResponse addGiftToWish(Long wishId);
    SimpleResponse charityReserve(ReserveRequestCharity reserveRequestCharity);
    SimpleResponse deleteCharity(Long userId,Long charityId);
    SimpleResponse deleteWish(Long userId,Long wishId);
    PaginationResponseWish getWishReservePagination(int page, int size);
    PaginationResponseCharity getCharityReservePagination(int page, int size);
}
