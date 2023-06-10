package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseProfile;
import com.example.giftlistb8.dto.complaint.request.ComplaintRequest;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseProfile;
import com.example.giftlistb8.entities.*;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.CharityRepository;
import com.example.giftlistb8.repositories.ComplaintRepository;
import com.example.giftlistb8.repositories.NotificationRepository;
import com.example.giftlistb8.repositories.WishRepository;
import com.example.giftlistb8.repositories.custom.ComplaintRepositoryCustom;
import com.example.giftlistb8.services.ComplaintService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class ComplaintServiceImpl implements ComplaintService {
    private final CharityRepository charityRepository;
    private final JwtService jwtService;
    private final NotificationRepository notificationRepository;
    private final WishRepository wishRepository;
    private final ComplaintRepositoryCustom complaintRepositoryCustom;

    @Override
    public SimpleResponse complaintToCharity(ComplaintRequest request) {

        Charity charity = charityRepository.findById(request.getId()).
                orElseThrow(() -> new NotFoundException("Charity with id %s not found.".formatted(request.getId())));

        User currentUser = jwtService.getUserInToken();

        Complaint complaint = Complaint.builder()
                .complaint(request.getComplaintDescription())
                .user(currentUser)
                .seen(false)
                .build();
        charity.getComplaints().add(complaint);

        charityRepository.save(charity);

        return SimpleResponse.builder()
                .message("Complaint to Charity added to database!")
                .status(HttpStatus.OK)
                .build();
    }


    @Override
    public SimpleResponse complaintToWish(ComplaintRequest request) {

        Wish wish = wishRepository.findById(request.getId()).
                orElseThrow(() -> new NotFoundException("Wish with id %s not found.".formatted(request.getId())));

        User currentUser = jwtService.getUserInToken();

        Complaint complaint = Complaint.builder()
                .complaint(request.getComplaintDescription())
                .user(currentUser)
                .seen(false)
                .build();
        wish.getComplaints().add(complaint);

        wishRepository.save(wish);

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

        if (!charityRepository.existsById(id)) {
            throw new BadRequestException("Благотворительность с id %s не найден.".formatted(id));
        }

        charityRepository.deleteFromReserve(id);
        charityRepository.deleteFromNotifications(id);
        charityRepository.deleteFromCharityComplaints(id);
        notificationRepository.deleteFromCharity(id);

        charityRepository.deleteCharity(id);

        return SimpleResponse.builder()
                .message("Благотворительность с id %s успешно удалена".formatted(id))
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public SimpleResponse deleteWish(Long id) {

        if (!wishRepository.existsById(id)) {
            throw new BadRequestException("Желаемый подарок с id %s не найден.".formatted(id));
        }

        wishRepository.deleteFromReserve(id);
        wishRepository.deleteFromNotification(id);
        wishRepository.deleteFromWishComplaints(id);
        notificationRepository.deleteFromWish(id);

        wishRepository.deleteWish(id);

        return SimpleResponse.builder()
                .message("Желаемый подарок с id %s успешно удалена".formatted(id))
                .status(HttpStatus.OK)
                .build();
    }
}