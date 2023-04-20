package com.example.giftlistb8.dto.reserve.response;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponseWish {
    private List<ReserveResponseWish> reserveResponseWishes;
    private int currentPage;
    private int pageSize;
}
