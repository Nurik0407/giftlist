package com.example.giftlistb8.dto.reserve.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReserveGetAllResponse {
    private List<ReserveResponseWish> wishes;
    private List<ReserveResponseCharity>charities;
}
