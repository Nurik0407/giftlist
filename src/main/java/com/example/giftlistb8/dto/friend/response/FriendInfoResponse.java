package com.example.giftlistb8.dto.friend.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public record FriendInfoResponse(
    Long id,
    String image,
   String fullName,
   int countOfWishes,
   int countOfHolidays
) {
}
