package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.services.FriendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Friend API", description = "User can send request,add and delete friends")
@RequestMapping("api/friends")
public class FriendAPI {

    private final FriendService friendService;

    @Operation(summary = "Get all friends, get all request", description = "User can see get all friends or get all request list")
    @GetMapping()
    public List<FriendInfoResponse> getAllFriendsAndAllRequests(@RequestParam(required = false) String type) {
        return friendService.getAllFriendsAndAllRequests(type);
    }

    @Operation(summary = "Manage friend relationship", description = "User can manage friend relationship")
    @PostMapping("{id}")
    public SimpleResponse sendAndDelete(@PathVariable Long id) {
        return friendService.sendAndDelete(id);
    }

    @Operation(summary = "Reject request to friend", description = "User can reject request to friend")
    @PostMapping("reject/{id}")
    public SimpleResponse reject(@PathVariable Long id) {
        return friendService.rejectRequest(id);
    }

    @Operation(summary = "Accept request to friend", description = "User can accept request to friend")
    @PostMapping("accept/{id}")
    public SimpleResponse accept(@PathVariable Long id) {
        return friendService.acceptRequest(id);
    }
}
