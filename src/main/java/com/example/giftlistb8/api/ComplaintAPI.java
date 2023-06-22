package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseProfile;
import com.example.giftlistb8.dto.complaint.request.ComplaintRequest;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseProfile;
import com.example.giftlistb8.services.ComplaintService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/complaint")
@RequiredArgsConstructor
@Tag(name = "Complaint API", description = "API for handling complaints")
@CrossOrigin(origins = "*")
public class ComplaintAPI {
    private final ComplaintService complaintService;

    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Complaint to Charity", description = "Complaint to charity method")
    @PostMapping("/charity")
    public SimpleResponse complaintToCharity(@RequestBody ComplaintRequest request) {
        return complaintService.complaintToCharity(request);
    }

    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Complaint to Wish", description = "Complaint to wish method")
    @PostMapping("/wish")
    public SimpleResponse complaintToWish(@RequestBody ComplaintRequest request) {
        return complaintService.complaintToWish(request);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "All complaints", description = "Get all complaint method")
    @GetMapping("/complaints")
    public ComplaintResponse getAllComplaints() {
        return complaintService.getAll();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Read more wish", description = "See more details wish")
    @GetMapping("/read-more-wish")
    public WishResponseProfile wishProfile(@RequestParam Long id) {
        return complaintService.wishFindById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Read more charity", description = "See more details charity")
    @GetMapping("/read-more-charity")
    public CharityResponseProfile charityProfile(@RequestParam Long id) {
        return complaintService.charityFindById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Delete charity", description = "Delete method charity")
    @DeleteMapping("/delete-charity")
    public SimpleResponse deleteCharity(@RequestParam Long id) {
        return complaintService.deleteCharity(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Block charity", description = "Block method charity")
    @GetMapping("block-charity")
    public SimpleResponse blockCharity(@RequestParam Long id) {
        return complaintService.blockCharity(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Delete wish", description = "Delete method wish")
    @DeleteMapping("/delete-wish")
    public SimpleResponse deleteWish(@RequestParam Long id) {
        return complaintService.deleteWish(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "Block wish", description = "Block method wish")
    @GetMapping("block-wish")
    public SimpleResponse blockWish(@RequestParam Long id) {
        return complaintService.blockWish(id);
    }
}