package com.example.giftlistb8.dto.reserve.response;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationResponseCharity {
    private List<ReserveResponseCharity> reserveResponseCharities;
    private int currentPage;
    private int pageSize;
}

