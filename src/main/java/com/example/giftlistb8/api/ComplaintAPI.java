package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.services.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/complaints/")
@RequiredArgsConstructor
public class ComplaintAPI {
    private final ComplaintService complaintService;

    @GetMapping("/charity/{id}")
    public SimpleResponse complaintToCharity(@PathVariable Long id) {
        return complaintService.complaintToCharity(id);
    }

    @GetMapping("/wish/{id}")
    public SimpleResponse complaintToWish(@PathVariable Long id) {
        return complaintService.complaintToWish(id);
    }

    @GetMapping("/all")
    public ComplaintResponse getAllComplaints(){
       return complaintService.getAll();
    }
}
