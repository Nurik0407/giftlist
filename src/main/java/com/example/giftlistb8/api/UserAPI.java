package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseProfile;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.notification.response.NotificationResponse;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;
import com.example.giftlistb8.dto.wish.response.WishResponseProfile;
import com.example.giftlistb8.services.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserAPI {
    private final UserService service;
    private final NotificationService notificationService;
    private final ComplaintService complaintService;
    private final CharityService charityService;
    private final WishService wishService;

    @GetMapping("/notifications")
    public List<NotificationResponse> getAllNotifications() {
        return notificationService.getAllMyNotifications();
    }

    @PostMapping()
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
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Get user by id", description = "Returns a single user  and user's holiday,wishes,charities.")
    @GetMapping("/{userId}")
    private UserResponseGetById getByIdWish(@PathVariable Long userId) {
        return service.getById(userId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Delete user by id", description = "Delete user with all information by id")
    @DeleteMapping("/{userId}")
    private SimpleResponse deleteById(@PathVariable Long userId) {
        return service.deleteById(userId);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Block user", description = "User block or un block method")
    @PutMapping("/{userId}/block")
    public SimpleResponse blockUser(@PathVariable Long userId, @RequestBody boolean blocked) {
        return service.updateBlockedStatus(userId, blocked);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "All complaints", description = "Get all complaint method")
    @GetMapping("/complaints")
    public ComplaintResponse getAllComplaints() {
        return complaintService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Read more wish", description = "See more details wish")
    @GetMapping("/read-more")
    public WishResponseProfile wishProfile(@RequestParam Long id) {
        return complaintService.wishFindById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Read more charity", description = "See more details charity")
    @GetMapping("/read-more")
    public CharityResponseProfile charityProfile(@RequestParam Long id) {
        return complaintService.charityFindById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Delete charity", description = "Delete method charity")
    @DeleteMapping("/delete-charity")
    public SimpleResponse deleteCharity(@RequestParam Long id) {
        return charityService.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Block charity", description = "Block method charity")
    @GetMapping("block-charity")
    public SimpleResponse blockCharity(@RequestParam Long id){
        return complaintService.blockCharity(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Delete wish", description = "Delete method wish")
    @DeleteMapping("/delete-wish")
    public SimpleResponse deleteWish(@RequestParam Long id) {
        return wishService.delete(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Block wish", description = "Block method wish")
    @GetMapping("block-wish")
    public SimpleResponse blockWish(@RequestParam Long id){
        return complaintService.blockWish(id);
    }
}
