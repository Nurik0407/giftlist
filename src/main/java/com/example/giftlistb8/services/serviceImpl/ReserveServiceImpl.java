package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestCharity;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestWish;
import com.example.giftlistb8.dto.reserve.response.*;
import com.example.giftlistb8.entities.*;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.CharityRepository;
import com.example.giftlistb8.repositories.ReserveRepository;
import com.example.giftlistb8.repositories.WishRepository;
import com.example.giftlistb8.services.ReserveService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class ReserveServiceImpl implements ReserveService {
    private final ReserveRepository reserveRepository;
    private final WishRepository wishRepository;
    private final JwtService jwtService;
    private final CharityRepository charityRepository;

    @Autowired
    public ReserveServiceImpl(ReserveRepository reserveRepository, WishRepository wishRepository, JwtService jwtService, CharityRepository charityRepository) {
        this.reserveRepository = reserveRepository;
        this.wishRepository = wishRepository;
        this.jwtService = jwtService;
        this.charityRepository = charityRepository;
    }

    @Override
    public SimpleResponse wishReserve(ReserveRequestWish reserveRequest) {
        User userInToken = jwtService.getUserInToken();
        Wish wish = wishRepository.findById(reserveRequest.wishId()).orElseThrow(
                () -> new NotFoundException(String.format("Wish with %s id not found", reserveRequest.wishId())));
        Reserve reserve = Reserve.builder()
                .user(userInToken)
                .wish(wish)
                .isAnonymous(false)
                .build();
        reserveRepository.save(reserve);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Gift with id %s successfully reserved", reserveRequest.id()))
                .build();
    }

    @Override
    public ReserveGetAllResponse getAllReserves() {
        return new ReserveGetAllResponse(reserveRepository.getAllReversesWish(), reserveRepository.getAllReversesCharity());
    }

    @Override
    public SimpleResponse addGiftToWish(Long wishId) {
        User userInToken = jwtService.getUserInToken();
        Wish wish = wishRepository.findById(wishId).orElseThrow(
                () -> new NotFoundException(String.format("Wish with %s id not found", wishId)));
        Wish newWish = new Wish();
        newWish.setName(wish.getName());
        newWish.setImage(wish.getImage());
        newWish.setDescription(wish.getDescription());
        newWish.setLinkGift(wish.getLinkGift());
        newWish.setUser(userInToken);
        wishRepository.save(newWish);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Gift with %s id successfully added to wish from reserves", wishId))
                .build();
    }

    @Override
    public SimpleResponse deleteWish(Long wishId) {
        User user = jwtService.getUserInToken();
        Wish wish = wishRepository.findById(wishId).orElseThrow(
                () -> new NotFoundException(String.format("Wish with %s not found", wishId)));
        Reserve reserve = reserveRepository.findByUserAndWish(user, wish)
                .orElseThrow(() -> new NotFoundException(String.format("Reserve for user %s and wish %s not found",
                        user.getId(), wish.getId())));
        reserveRepository.delete(reserve);
        return SimpleResponse.builder().httpStatus(HttpStatus.OK)
                .message(String.format("Reserve for user %s and wish %s has been deleted", user.getUsername(), wishId))
                .build();
    }

    @Override
    public SimpleResponse charityReserve(ReserveRequestCharity reserveRequestCharity) {
        User user = jwtService.getUserInToken();
        Charity charity = charityRepository.findById(reserveRequestCharity.charityId()).orElseThrow(
                () -> new NotFoundException(String.format("Charity with %s id not found", reserveRequestCharity.charityId())));
        Reserve reserve = new Reserve();
        reserve.setUser(user);
        reserve.setCharity(charity);
        reserve.setIsAnonymous(true);
        reserveRepository.save(reserve);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message(String.format("Charity with  %s  id successfully reserved", reserveRequestCharity.id()))
                .build();
    }

    @Override
    public SimpleResponse deleteCharity(Long charityId) {
        User user = jwtService.getUserInToken();
        Charity charity = charityRepository.findById(charityId).orElseThrow(
                () -> new NotFoundException(String.format("Charity with %s id not found", charityId)));
        Reserve reserve = reserveRepository.findByUserAndCharity(user, charity)
                .orElseThrow(() -> new NotFoundException(String.format("Reserve for user %s and wish %s not found",
                        user.getId(), charity.getId())));
        reserveRepository.delete(reserve);
        return SimpleResponse.builder().httpStatus(HttpStatus.OK)
                .message(String.format("Reserve for user %s and wish %s has been deleted", user.getUsername(), charityId))
                .build();
    }

    @Override
    public PaginationResponseWish getWishReservePagination(int page, int size) {
//        Pageable pageable = PageRequest.of(page - 1, size);
//        Page<ReserveResponseWish> pagedWishes = reserveRepository.findAllWishBy(pageable);
////        List<ReserveResponseWish> responseWishes = pagedWishes.getContent().stream()
////                .map(reserve -> new ReserveResponseWish(
////                        reserve.id(),
////                        reserve.fullName(),
////                        reserve.photo(),
////                        reserve.holidayName(),
////                        reserve.date(),
////                        reserve.giftName(),
////                        reserve.image()))
////                .collect(Collectors.toList());
//        return PaginationResponseWish.builder()
//                .reserveResponseWishes(pagedWishes.getContent())
//                .pageSize(pagedWishes.getNumber() + 1)
//                .currentPage(pagedWishes.getTotalPages())
//                .build();
        return null;


    }


    @Override
    public PaginationResponseCharity getCharityReservePagination(int page, int size) {
//        Pageable pageable = PageRequest.of(page - 1, size);
//       Page<ReserveResponseCharity> pagedCharity = reserveRepository.getAll(pageable);
////        List<ReserveResponseCharity> responseCharities = pagedCharity.getContent().stream()
////                .map(reserve -> new ReserveResponseCharity(
////                        reserve.id(),
////                        reserve.fullName(),
////                        reserve.photo(),
////                        reserve.charityName(),
////                        reserve.state(),
////                        reserve.image(),
////                        reserve.date()))
////                .toList();
//        // List<ReserveResponseCharity> content = pagedCharity.getContent();
//        return PaginationResponseCharity.builder()
//                .reserveResponseCharities(pagedCharity.getContent())
//                .currentPage(pagedCharity.getTotalPages())
//                .pageSize(pagedCharity.getNumber() + 1)
//                .build();
        return null;

    }
}



