package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.profile.request.ChangePasswordUser;
import com.example.giftlistb8.dto.profile.request.ProfileRequest;
import com.example.giftlistb8.dto.profile.request.ProfileUpdateRequest;
import com.example.giftlistb8.dto.profile.response.ProfileResponse;
import com.example.giftlistb8.dto.profile.response.ProfileResponseGetById;
import com.example.giftlistb8.services.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
@Tag(name = "Profiles ", description = "User profile  all information.")
public class ProfileApi {
    private final ProfileService profileService;

    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "User save method", description = " This method for saving all user information.")
    @PostMapping
    public SimpleResponse saveUserProfile(@RequestBody ProfileRequest profileRequest) {
        return profileService.saveUser(profileRequest);
    }

    @PermitAll
    @Operation(summary = "Get user by id", description = "Get user base information  by id")
    @GetMapping
    public ProfileResponseGetById getById() {
        return profileService.getById();
    }

    @PermitAll
    @Operation(summary = "Get user detail information by id", description = "Get user all information by id")
    @GetMapping("/detail")
    public ProfileResponse getByIdUserDetail() {
        return profileService.getByIdDetailInformation();
    }

    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Change user password", description = "This method changed old password for ne w password")
    @PostMapping("/password")
    public SimpleResponse changePassword(@RequestBody ChangePasswordUser changePasswordUser) {
        return profileService.changeUserPassword(changePasswordUser);
    }

    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Update user information", description = "The method update user profile")
    @PutMapping
    public SimpleResponse updateUser(@RequestBody ProfileUpdateRequest profileUpdateRequest) {
        return profileService.updateUserProfile(profileUpdateRequest);
    }
}
