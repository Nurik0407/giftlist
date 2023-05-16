package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseProfile;
import com.example.giftlistb8.dto.complaint.request.ComplaintRequest;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseProfile;

public interface ComplaintService {

    SimpleResponse complaintToCharity(ComplaintRequest request);
    SimpleResponse complaintToWish(ComplaintRequest request);

    ComplaintResponse getAll();

    WishResponseProfile wishFindById(Long id);

    CharityResponseProfile charityFindById(Long id);

    SimpleResponse blockCharity(Long id);

    SimpleResponse blockWish(Long id);
}
