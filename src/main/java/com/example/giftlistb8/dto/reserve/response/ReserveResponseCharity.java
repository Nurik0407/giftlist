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
    public ReserveResponseCharity(Long reserveId, Long charityId, String fullName, String photo, String charityName, String image, String state, LocalDate date) {
        this.reserveId = reserveId;
        this.charityId = charityId;
        this.fullName = fullName;
        this.photo = photo;
        this.charityName = charityName;
        this.image = image;
        this.state = state;
        this.date = date;
    }
}
