package com.example.giftlistb8.dto.profile.response;

import lombok.Builder;

@Builder
public record ProfileResponseGetById(
        Long id,
        String image,
        String fullName,
        String email

) {
    public ProfileResponseGetById(Long id, String image, String fullName, String email) {
        this.id = id;
        this.image = image;
        this.fullName = fullName;
        this.email = email;
    }
}
