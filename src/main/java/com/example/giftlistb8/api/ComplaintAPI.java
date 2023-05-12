package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.services.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaints")
@RequiredArgsConstructor
public class ComplaintAPI {
    private final ComplaintService complaintService;

    @GetMapping("/charity")
    public SimpleResponse complaintToCharity(@RequestParam Long id) {
        return complaintService.complaintToCharity(id);
    }

    @GetMapping("/wish")
    public SimpleResponse complaintToWish(@RequestParam Long id) {
        return complaintService.complaintToWish(id);
    }

    @GetMapping("/all")
    public ComplaintResponse getAllComplaints() {
        return complaintService.getAll();
    }

    @GetMapping("/wish-profile")
    public CharityResponse profile(@RequestParam Long id) {
        return complaintService.findById(id);
    }
}
