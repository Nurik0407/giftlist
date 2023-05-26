package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.user.requests.UpdateBlockStatus;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;
import com.example.giftlistb8.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@Tag(name = "User API", description = "API for managing user data")
public class UserAPI {
    private final UserService service;
    private final NotificationService notificationService;

    @GetMapping("/notifications")
    public List<NotificationResponse> getAllNotifications() {
        return notificationService.getAllMyNotifications();
    }

    @PostMapping
    public SimpleResponse seenOrNot() {
        return notificationService.seenOrNot();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Get all users", description = "Returns a paginated list of all users.")
    @GetMapping
    public PaginationResponse<UserResponseGetAll> getAll(@RequestParam(defaultValue = "1") int page,
                                                         @RequestParam(defaultValue = "6") int size) {
        return service.getAllUsers(page, size);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @Operation(summary = "Get user by id", description = "Returns a single user  and user's holiday,wishes,charities.")
    @GetMapping("/{userId}")
    private UserResponseGetById getById(@PathVariable Long userId) {
        return service.getById(userId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Delete user by id", description = "Delete user with all information by id")
    @DeleteMapping
    private SimpleResponse deleteById(@RequestParam Long userId) {
        return service.deleteById(userId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Block user", description = "User block or un block method")
    @PutMapping
    public SimpleResponse blockUser(@RequestBody @Valid UpdateBlockStatus updateBlockStatus) {
        return service.updateBlockedStatus(updateBlockStatus);
    }
}