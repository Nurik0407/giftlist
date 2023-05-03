package com.example.giftlistb8.dto.friend.response;

import com.example.giftlistb8.entities.User;
import lombok.*;

@Getter
@Builder
public class FriendInfoResponse {
    private Long id;
    private String image;
    private String fullName;
    private int countOfWishes;
    private int countOfHolidays;

    public FriendInfoResponse(Long id, String image, String fullName, int countOfWishes, int countOfHolidays) {
        this.id = id;
        this.image = image;
        this.fullName = fullName;
        this.countOfWishes = countOfWishes;
        this.countOfHolidays = countOfHolidays;
    }
}

