package com.example.giftlistb8.dto.wish.response;

import com.example.giftlistb8.dto.user.response.WhoComplaintResponse;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 390fdea (add some methods to complaint)
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
=======
import lombok.Builder;
>>>>>>> 8e60948 (added CharityResponseProfile)
=======
>>>>>>> 390fdea (add some methods to complaint)

import java.time.LocalDate;
import java.util.List;

@Builder
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 390fdea (add some methods to complaint)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishResponseProfile{
        private Long userId;
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
<<<<<<< HEAD
=======
public record WishResponseProfile(
        Long id,
        String fullName,
        String userImage,
        String phoneNumber,
        String wishName,
        String description,
        LocalDate date,
        String holidayName,
        String status,
        String wishImage,
        boolean isReserved,
        boolean isAnonymous,
        List<WhoComplaintResponse> whoComplaintResponses
) {
>>>>>>> 8e60948 (added CharityResponseProfile)
=======
>>>>>>> 390fdea (add some methods to complaint)
}
