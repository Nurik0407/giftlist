package com.example.giftlistb8.dto.charity.response;

import lombok.Builder;

@Builder
public record CharityResponseWithComplaint(
        Long id,
        String fullName,
        String userImage,
        String name,
        java.sql.Date dateOfIssue,
        String charityImage,
        String whomUserImage,
        String complaintMessage
) { }
