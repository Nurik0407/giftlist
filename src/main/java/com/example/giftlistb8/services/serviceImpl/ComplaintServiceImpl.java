package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.entities.Charity;
import com.example.giftlistb8.entities.Complaint;
import com.example.giftlistb8.entities.Notification;
import com.example.giftlistb8.entities.Wish;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.CharityRepository;
import com.example.giftlistb8.repositories.ComplaintRepository;
import com.example.giftlistb8.repositories.NotificationRepository;
import com.example.giftlistb8.repositories.WishRepository;
import com.example.giftlistb8.repositories.custom.ComplaintRepositoryCustom;
import com.example.giftlistb8.services.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.example.giftlistb8.enums.Type.COMPLAINT;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {
    private final CharityRepository charityRepository;
    private final ComplaintRepository complaintRepository;
    private final JwtService jwtService;
    private final NotificationRepository notificationRepository;
    private final WishRepository wishRepository;
    private final ComplaintRepositoryCustom complaintRepositoryCustom;

    @Override
    public SimpleResponse complaintToCharity(Long id) {
        Notification notification = new Notification();
        Complaint complaint = new Complaint();


        Charity charity = charityRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found!"));

        complaint.setComplaint("Here will be the reason for the complaint");
        charity.getComplaints().add(complaint);
        complaint.setUser(jwtService.getUserInToken());

        notification.setType(COMPLAINT);
        notification.setSeen(false);
        notification.setCreatedAt(LocalDate.now());
        notification.setFromWhomUser(jwtService.getUserInToken());
        notification.setToWhomUser(charity.getUser());
        notification.setCharity(charity);

        notificationRepository.save(notification);

        complaintRepository.save(complaint);

        return SimpleResponse.builder()
                .message("Complaint to Charity added to database!")
                .status(HttpStatus.OK)
                .build();
    }


    @Override
    public SimpleResponse complaintToWish(Long id) {
        Notification notification = new Notification();
        Complaint complaint = new Complaint();
        Wish wish = wishRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found!"));

        complaint.setComplaint("Here will be the reason for the complaint");
        wish.getComplaints().add(complaint);
        complaint.setUser(jwtService.getUserInToken());

        notification.setType(COMPLAINT);
        notification.setSeen(false);
        notification.setCreatedAt(LocalDate.now());
        notification.setFromWhomUser(jwtService.getUserInToken());
        notification.setToWhomUser(wish.getUser());
        notification.setWish(wish);

        notificationRepository.save(notification);

        complaintRepository.save(complaint);

        return SimpleResponse.builder()
                .message("Complaint to Charity added to database!")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public ComplaintResponse getAll() {
        return complaintRepositoryCustom.getAllComplaints();
    }

}
