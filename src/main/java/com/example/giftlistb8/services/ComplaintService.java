package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseProfile;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseProfile;

public interface ComplaintService {

    SimpleResponse complaintToCharity(Long id);
    SimpleResponse complaintToWish(Long id);

    ComplaintResponse getAll();

    WishResponseProfile wishFindById(Long id);

    CharityResponseProfile charityFindById(Long id);
}
