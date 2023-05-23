package com.example.giftlistb8.dto.charity.response;


import com.example.giftlistb8.dto.user.response.WhoComplaintResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
}
