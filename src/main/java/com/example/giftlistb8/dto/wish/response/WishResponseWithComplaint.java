package com.example.giftlistb8.dto.wish.response;

import lombok.Builder;

@Builder
public record WishResponseWithComplaint(
        Long id,
        String fullName,
        String userImage,
        String name,
        java.sql.Date dateOfIssue,
        String wishImage,
        String whomUserImage,
        String complaintMessage
) {
}
