package com.example.giftlistb8.dto.reserve.response;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ReserveResponseCharity(
        Long reserveId,
        Long charityId,
        String fullName,
        String photo,
        String charityName,
        String image,
        String state,
        LocalDate date

) {
}
