package com.example.giftlistb8.dto.user.response;

import lombok.Builder;

@Builder
public record WhoComplaintResponse(
        Long userId,
        String fullName,
        String userImage,
        String causesOfComplaint
) {
}
