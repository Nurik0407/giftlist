package com.example.giftlistb8.dto.charity.response;

<<<<<<< HEAD
<<<<<<< HEAD
import com.example.giftlistb8.dto.user.response.WhoComplaintResponse;
import lombok.Getter;
import lombok.Setter;
=======
import com.example.giftlistb8.dto.user.response.UserResponseGetById;
import com.example.giftlistb8.dto.user.response.WhoComplaintResponse;
import lombok.Builder;
>>>>>>> 8e60948 (added CharityResponseProfile)
=======
import com.example.giftlistb8.dto.user.response.WhoComplaintResponse;
import lombok.Getter;
import lombok.Setter;
>>>>>>> 390fdea (add some methods to complaint)

import java.time.LocalDate;
import java.util.List;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 390fdea (add some methods to complaint)
@Getter
@Setter
public class CharityResponseProfile {
    private Long userId;
    private String fullName;
    private String userImage;
    private String phoneNumber;
    private String charityName;
    private String description;
    private String category;
    private String subCategory;
    private String state;
    private LocalDate dateAdded;
    private String charityImage;
    private boolean isReserved;
    private boolean isAnonymous;
    private List<WhoComplaintResponse> whoComplaintResponses;
<<<<<<< HEAD
=======
@Builder
public record CharityResponseProfile(
        Long id,
        String fullName,
        String userImage,
        String phoneNumber,
        String charityName,
        String description,
        String category,
        String subCategory,
        String state,
        LocalDate dateAdded,
        String image,
        boolean isReserved,
        boolean isAnonymous,
        List<WhoComplaintResponse> whoComplaintResponses
) {
>>>>>>> 8e60948 (added CharityResponseProfile)
=======
>>>>>>> 390fdea (add some methods to complaint)
}
