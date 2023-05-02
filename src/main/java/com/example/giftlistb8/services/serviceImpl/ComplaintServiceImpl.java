package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.entities.Charity;
import com.example.giftlistb8.entities.Complaint;
import com.example.giftlistb8.entities.Notification;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.CharityRepository;
import com.example.giftlistb8.repositories.ComplaintRepository;
import com.example.giftlistb8.services.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {
    private final CharityRepository charityRepository;
    private final ComplaintRepository complaintRepository;

    @Override
    public SimpleResponse complaintToCharity(Long id) {
        Notification notification = new Notification();
        notification.setSeen(false);
        Charity charity = charityRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found!"));

        Complaint complaint = new Complaint();
        complaint.setComplaint("Here will be the reason for the complaint");
        charity.getComplaints().add(complaint);

        complaintRepository.save(complaint);

        return SimpleResponse.builder()
                .message("Complaint to Charity added to database!")
                .status(HttpStatus.OK)
                .build();
    }
}
