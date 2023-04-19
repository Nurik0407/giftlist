package com.example.giftlistb8.services;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestCharity;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestWish;
import com.example.giftlistb8.dto.reserve.response.ReserveGetAllResponse;
import com.example.giftlistb8.dto.reserve.response.SimpleResponse;

public interface ReserveService {
    SimpleResponse wishReserve(ReserveRequestWish reserveRequest);
    ReserveGetAllResponse getAllReserves();
    SimpleResponse addGiftToWish(Long wishId);
    SimpleResponse deleteWish(Long wishId);
    SimpleResponse charityReserve(ReserveRequestCharity reserveRequestCharity);
    SimpleResponse deleteCharity(Long charityId);
}
