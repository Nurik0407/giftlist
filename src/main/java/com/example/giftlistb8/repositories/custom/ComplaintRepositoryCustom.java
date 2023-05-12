package com.example.giftlistb8.repositories.custom;

import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseProfile;

import java.util.List;

public interface ComplaintRepositoryCustom {
    ComplaintResponse getAllComplaints();
    WishResponseProfile getById(Long id);
}
