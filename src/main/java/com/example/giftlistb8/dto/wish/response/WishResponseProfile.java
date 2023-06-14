package com.example.giftlistb8.dto.wish.response;

import com.example.giftlistb8.dto.user.response.WhoComplaintResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishResponseProfile{
        private Long userId;
        private Long wishId;
        private String fullName;
        private String userImage;
        private String phoneNumber;
        private String wishName;
        private String description;
        private LocalDate date;
        private String holidayName;
        private String status;
        private String wishImage;
        private boolean isReserved;
        private boolean isAnonymous;
        private String reserveUserImage;
        private List<WhoComplaintResponse> whoComplaintResponses;
}
