package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.complaint.request.ComplaintRequest;
import com.example.giftlistb8.services.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaints")
@RequiredArgsConstructor
public class ComplaintAPI {
    private final ComplaintService complaintService;

    @GetMapping("/charity")
    public SimpleResponse complaintToCharity(@RequestBody ComplaintRequest request) {
        return complaintService.complaintToCharity(request);
    }

    @GetMapping("/wish")
    public SimpleResponse complaintToWish(@RequestBody ComplaintRequest request) {
        return complaintService.complaintToWish(request);
    }


}
