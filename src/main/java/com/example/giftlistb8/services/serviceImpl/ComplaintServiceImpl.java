package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseProfile;
import com.example.giftlistb8.dto.complaint.request.ComplaintRequest;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseProfile;
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
    public SimpleResponse complaintToCharity(ComplaintRequest request) {
        Notification notification = new Notification();
        Complaint complaint = new Complaint();


        Charity charity = charityRepository.findById(request.getId()).
                orElseThrow(() -> new NotFoundException("Not found!"));

        complaint.setComplaint(request.getComplaintDescription());
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
    public SimpleResponse complaintToWish(ComplaintRequest request) {
        Notification notification = new Notification();
        Complaint complaint = new Complaint();
        Wish wish = wishRepository.findById(request.getId()).
                orElseThrow(() -> new NotFoundException("Not found!"));

        complaint.setComplaint(request.getComplaintDescription());
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
    public SimpleResponse blockCharity(Long id) {
        Charity charity = charityRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found!"));
        charity.setBlocked(true);
        charityRepository.save(charity);
        return SimpleResponse.builder()
                .message("Charity with id " + id + " is blocked!")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public SimpleResponse blockWish(Long id) {
        Wish wish = wishRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found!"));
        wish.setBlocked(true);
        wishRepository.save(wish);
        return SimpleResponse.builder()
                .message("Wish with id " + id + "is blocked!")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public WishResponseProfile wishFindById(Long id) {
        return complaintRepositoryCustom.wishGetById(id);
    }

    @Override
    public CharityResponseProfile charityFindById(Long id) {
        return complaintRepositoryCustom.charityGetById(id);
    }

    @Override
    public ComplaintResponse getAll() {
        return complaintRepositoryCustom.getAllComplaints();
    }

    @Override
    public SimpleResponse deleteCharity(Long id) {
        Charity charity = charityRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Charity with " + id + " is not found!"));
        charity.setUser(null);
        Notification notification = notificationRepository.findByCharityId(id);
        notification.setCharity(null);
        notificationRepository.save(notification);
        charityRepository.deleteById(id);
        return SimpleResponse.builder()
                .message("Wish charity id " + id + "is deleted!")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public SimpleResponse deleteWish(Long id) {
        Wish wish = wishRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Wish with this id not found!"));
        Notification notification = notificationRepository.findByWishId(id);
        notification.setWish(null);
        notificationRepository.save(notification);

        wishRepository.deleteById(id);
        return SimpleResponse.builder()
                .message("Wish with id " + id + "is deleted!")
                .status(HttpStatus.OK)
                .build();
    }
}