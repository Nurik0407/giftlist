package com.example.giftlistb8.repositories.custom;

import com.example.giftlistb8.dto.charity.response.CharityResponseProfile;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseProfile;

public interface ComplaintRepositoryCustom {
    ComplaintResponse getAllComplaints();
    WishResponseProfile wishGetById(Long id);

    CharityResponseProfile charityGetById(Long id);
}

