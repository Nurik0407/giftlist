package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.profile.request.ProfileRequest;
import com.example.giftlistb8.dto.profile.request.UpdateProfileRequest;
import com.example.giftlistb8.dto.profile.response.FriendsProfileResponse;
import com.example.giftlistb8.dto.profile.response.MyProfileResponse;
import com.example.giftlistb8.dto.profile.response.ProfileResponse;
import com.example.giftlistb8.services.serviceImpl.ProfileServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@Tag(name = "Profile Api", description = "Save/Update profile")
@PreAuthorize("hasAuthority('USER')")
public class ProfileApi {
    private final ProfileServiceImpl profileService;

    @Operation(description = "Set profile information", summary = "Save profile")
    @PostMapping
    public ProfileResponse save(@RequestBody ProfileRequest profileRequest) {
        return profileService.saveProfile(profileRequest);
    }

    @Operation(summary = "Get my profile")
    @GetMapping("/myProfile")
    public MyProfileResponse getProfile() {
        return profileService.getMyProfile();
    }

    @Operation(summary = "Get my full profile")
    @GetMapping
    public ProfileResponse getFullProfile() {
        return profileService.getMyFullProfile();
    }

    @Operation(summary = "Get my friend's profile")
    @GetMapping("/{id}")
    public FriendsProfileResponse getFriendsProfile(@PathVariable Long id) {
        return profileService.getFriendsProfile(id);
    }

    @Operation(description = "Update profile information", summary = "Update profile")
    @PutMapping("/{id}")
    public SimpleResponse updateProfile(@PathVariable Long id,
                                        @RequestBody UpdateProfileRequest profileRequest) {
        return profileService.saveUpdatedProfile(id, profileRequest);
    }
}
