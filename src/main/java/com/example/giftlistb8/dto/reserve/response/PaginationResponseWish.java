package com.example.giftlistb8.dto.reserve.response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PaginationResponseWish {
    private List<ReserveResponseWish> reserveResponseWishes;
    private int currentPage;
    private int pageSize;
}
