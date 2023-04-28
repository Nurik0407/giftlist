package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.feed.response.FeedResponse;
import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.services.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feeds")
@RequiredArgsConstructor
@Tag(name = "UserAccountFeed", description = "Users profile feed which show latest reserve wishes")
public class FeedApi {
    private final FeedService feedService;

    @Operation(summary = "Get all wishes", description = "Returns a paginated list of all wishes.")
    @GetMapping
    public PaginationResponse<FeedResponse> getAll(@RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "6") int size) {
        return feedService.getAll(page, size);
    }

    @Operation(summary = "Get wish by id", description = "Returns a single wish by its id.")
    @GetMapping("/{wishId}")
    private FeedResponse getByIdWish(@PathVariable Long wishId) {
        return feedService.getById(wishId);
    }
}
