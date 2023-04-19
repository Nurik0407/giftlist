package com.example.giftlistb8.api;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestCharity;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestWish;
import com.example.giftlistb8.dto.reserve.response.PaginationResponseWish;
import com.example.giftlistb8.dto.reserve.response.PaginationResponseCharity;
import com.example.giftlistb8.dto.reserve.response.ReserveGetAllResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserves")
public class ReserveApi {
    private final ReserveService reserveService;
    @Autowired
    public ReserveApi(ReserveService reserveService) {
        this.reserveService = reserveService;
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/wish")
    public SimpleResponse wishReserve(ReserveRequestWish reserveRequest) {
        return reserveService.wishReserve(reserveRequest);
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/charity")
    public SimpleResponse charityReserve(ReserveRequestCharity reserveRequestCharity) {
        return reserveService.charityReserve(reserveRequestCharity);
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public ReserveGetAllResponse getAllReserves() {
        return reserveService.getAllReserves();
    }
    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/{wishId}")
    public SimpleResponse addGiftToWish(@PathVariable Long wishId) {
        return reserveService.addGiftToWish(wishId);
    }
    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("/{wishId}")
    public SimpleResponse deleteWish(@PathVariable Long wishId) {
        return reserveService.deleteWish(wishId);
    }
    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("/{charityId}")
    public SimpleResponse deleteCharity(@PathVariable Long charityId) {
        return reserveService.deleteCharity(charityId);
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/pagination-wish")
    public PaginationResponseWish getWishPagination(@RequestParam (defaultValue = "1") int page, @RequestParam (defaultValue = "10") int size){
        return reserveService.getWishReservePagination(page, size);
    }
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/pagination-charity")
    public PaginationResponseCharity getCharityPagination(@RequestParam (defaultValue = "1") int page, @RequestParam (defaultValue = "10") int size){
        return reserveService.getCharityReservePagination(page, size);
    }
}
