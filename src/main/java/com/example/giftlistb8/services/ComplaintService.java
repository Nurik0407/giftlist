package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;


public interface ComplaintService {

    SimpleResponse complaintToCharity(Long id);
    SimpleResponse complaintToWish(Long id);

    ComplaintResponse getAll();
}
