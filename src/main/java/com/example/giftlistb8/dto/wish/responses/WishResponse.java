package com.example.giftlistb8.dto.wish.responses;

import lombok.Builder;

@Builder
public record WishResponse(
    Long id,
    String name,
    String image,
    Boolean status){
    public WishResponse(Long id, String name, String image, Boolean status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
    }
}
