package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestCharity;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestWish;
import com.example.giftlistb8.dto.reserve.response.ReserveGetAllResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.reserve.response.ReserveSimpleResponse;
import com.example.giftlistb8.services.ReserveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reserves")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
@Tag(name = "Reserves", description = "API endpoints for managing reserves")
@CrossOrigin(origins = "*")
public class ReserveApi {
    private final ReserveService reserveService;

    @Operation(summary = "This method for reserve the wish",
            description = "Reserve a wish as anonymous or non anonymous user with the given wish ID.")
    @PostMapping("/wish")
    public ReserveSimpleResponse wishReserve(ReserveRequestWish reserveRequest) {
        return reserveService.wishReserve(reserveRequest);
    }

    @Operation(summary = "This method for reserve the gift from charity",
            description = "Reserve a wish as anonymous or non anonymous user with the given wish ID.")
    @PostMapping("/charity")
    public ReserveSimpleResponse charityReserve(ReserveRequestCharity reserveRequestCharity) {
        return reserveService.charityReserve(reserveRequestCharity);
    }

    @Operation(summary = "Get all reserves",
            description = "Get all reserves including reserved wishes and reserved charities.")
    @GetMapping
    public ReserveGetAllResponse getAllReserves() {
        return reserveService.getAllReserves();
    }

    @Operation(summary = "The method added gift to own wishList", description = "Add a reserved gift to a wish")
    @PostMapping()
    public SimpleResponse addGiftToWish(@RequestParam(required = false) Long wishId) {
        return reserveService.addGiftToWish(wishId);
    }

    @Operation(summary = "Get wish reserve pagination",
            description = "Returns a paginated list of wish reserves.")
    @GetMapping("/pagination-wish")
    public PaginationResponse getWishPagination(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return reserveService.getWishReservePagination(page, size);
    }

    @Operation(summary = "Get gift reserve pagination",
            description = "Returns a paginated list of gift reserves.")
    @GetMapping("/pagination-charity")
    public PaginationResponse getCharityPagination(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return reserveService.getCharityReservePagination(page, size);
    }


    @Operation(summary = "Delete wish method", description = "Cancel wish from reserve")
    @DeleteMapping("/{wishId}/{userId}")
    public SimpleResponse deleteWish(@PathVariable Long userId, @PathVariable Long wishId) {
        return reserveService.deleteWish(userId, wishId);
    }

    @Operation(summary = "Delete the gift", description = "Cancel gift from reserve")
    @DeleteMapping("/{charityId}/{userId}")
    public SimpleResponse deleteCharity(@PathVariable Long userId, @PathVariable Long charityId) {
        return reserveService.deleteCharity(userId, charityId);
    }
}
