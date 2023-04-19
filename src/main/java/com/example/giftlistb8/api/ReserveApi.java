package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.reserve.requests.ReserveRequestCharity;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestWish;
import com.example.giftlistb8.dto.reserve.response.ReserveGetAllResponse;
import com.example.giftlistb8.dto.reserve.response.SimpleResponse;
import com.example.giftlistb8.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserves")
public class ReserveApi {
    private final ReserveService reserveService;

    @Autowired

    public ReserveApi(ReserveService reserveService) {
        this.reserveService = reserveService;
    }

    @PostMapping("/wish")
    public SimpleResponse wishReserve(ReserveRequestWish reserveRequest) {
        return reserveService.wishReserve(reserveRequest);
    }

    @PostMapping("/charity")
    public SimpleResponse charityReserve(ReserveRequestCharity reserveRequestCharity) {
        return reserveService.charityReserve(reserveRequestCharity);
    }

    @GetMapping
    public ReserveGetAllResponse getAllReserves() {
        return reserveService.getAllReserves();
    }

    @PostMapping("/{wishId}")
    public SimpleResponse addGiftToWish(@PathVariable Long wishId) {
        return reserveService.addGiftToWish(wishId);
    }

    @DeleteMapping("/{wishId}")
    public SimpleResponse deleteWish(@PathVariable Long wishId) {
        return reserveService.deleteWish(wishId);
    }

    @DeleteMapping("/{charityId}")
    public SimpleResponse deleteCharity(@PathVariable Long charityId) {
        return reserveService.deleteCharity(charityId);
    }
}
