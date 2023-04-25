package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.services.serviceImpl.FriendServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
@Tag(name = "Friends Api", description = "User can send request,add and delete friends")
@RequestMapping("api/friends")
public class FriendApi {

    private final FriendServiceImpl friendServiceImpl;

    @Operation(summary = "Get all friends", description = "User can see get all friends list")
    @GetMapping
    public List<FriendInfoResponse> getAllFriends() {
        return friendServiceImpl.getAllFriends();
    }

    @Operation(summary = "Get all requests", description = "User can see get all requests")
    @GetMapping("requests")
    public List<FriendInfoResponse> getAllRequests() {
        return friendServiceImpl.getAllRequests();
    }

    @Operation(summary = "Send request to friend", description = "User can send request to friend")
    @PostMapping("request/{id}")
    public SimpleResponse requestToFriend(@PathVariable Long id) {
        return friendServiceImpl.sendRequestToFriend(id);
    }

    @Operation(summary = "Reject request to friend", description = "User can reject request to friend")
    @PostMapping("reject/{id}")
    public SimpleResponse reject(@PathVariable Long id) {
        return friendServiceImpl.rejectRequest(id);
    }

    @Operation(summary = "Accept request to friend", description = "User can accept request to friend")
    @PostMapping("accept/{id}")
    public SimpleResponse accept(@PathVariable Long id) {
        return friendServiceImpl.acceptRequest(id);
    }

    @Operation(summary = "Delete from friend", description = "User can delete from friends")
    @DeleteMapping("{id}")
    public SimpleResponse deleteFromFriend(@PathVariable Long id) {
        return friendServiceImpl.deleteFromFriends(id);
    }

    @Operation(summary = "Cancel request to friend", description = "User can cancel request to friend")
    @PostMapping("cancel/{id}")
    public SimpleResponse cancelRequestToFriend(@PathVariable Long id) {
        return friendServiceImpl.cancelRequestToFriend(id);
    }
}
