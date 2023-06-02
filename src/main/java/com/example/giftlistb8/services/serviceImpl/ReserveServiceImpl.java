package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestCharity;
import com.example.giftlistb8.dto.reserve.requests.ReserveRequestWish;
import com.example.giftlistb8.dto.reserve.response.*;
import com.example.giftlistb8.entities.*;
import com.example.giftlistb8.enums.Type;
import com.example.giftlistb8.exceptions.AlreadyExistsException;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.ForbiddenException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.*;
import com.example.giftlistb8.services.ReserveService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ReserveServiceImpl implements ReserveService {
    private final NotificationRepository notificationRepository;
    private final ReserveRepository reserveRepository;
    private final WishRepository wishRepository;
    private final JwtService jwtService;
    private final CharityRepository charityRepository;
    private final HolidayRepository holidayRepository;

    @Override
    public ReserveSimpleResponse wishReserve(ReserveRequestWish reserveRequest) {
        User userInToken = jwtService.getUserInToken();
        Wish wish = wishRepository.findById(reserveRequest.wishId()).orElseThrow(
                () -> new NotFoundException(String.format("Wish with %s id not found", reserveRequest.wishId())));
        if (userInToken.getWishes().contains(wish)) {
            throw new BadRequestException("The booking operation is not possible for the gifts you want.");
        }
        if (reserveRepository.wishReserved(wish.getId())) {
            throw new AlreadyExistsException("Wish with id %s already reserved.".formatted(wish.getId()));
        }
        boolean isAnonymous = reserveRequest.isAnonymous();
        Reserve reserve = Reserve.builder()
                .isAnonymous(isAnonymous)
                .wish(wish)
                .user(userInToken)
                .build();
        wish.setStatus(true);
        wishRepository.save(wish);
        reserveRepository.save(reserve);

        Notification notification = Notification.builder()
                .reserve(reserve)
                .seen(false)
                .toWhomUser(wish.getUser())
                .fromWhomUser(userInToken)
                .createdAt(LocalDate.now())
                .build();
        if (isAnonymous) {
            notification.setType(Type.BOOKED_ANONYMOUSLY);
            notification.setMessage("%s было забронировано анонимным пользователем.".formatted(wish.getName()));
        } else {
            notification.setType(Type.BOOKED_NOT_ANONYMOUSLY);
            notification.setMessage("%s было забронировано пользователем %s %s".formatted(wish.getName(), userInToken.getLastName(), userInToken.getFirstName()));
        }
        notificationRepository.save(notification);

        log.info("Reserving wish with id {}", reserveRequest.wishId());
        return ReserveSimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message(String.format("Gift with id %s successfully reserved", reserveRequest.wishId()))
                .build();
    }

    @Override
    public ReserveSimpleResponse charityReserve(ReserveRequestCharity reserveRequestCharity) {
        User userInToken = jwtService.getUserInToken();
        Charity charity = charityRepository.findById(reserveRequestCharity.charityId()).orElseThrow(
                () -> new NotFoundException(String.format("Charity with id %s not found", reserveRequestCharity.charityId())));
        if (userInToken.getCharities().contains(charity)) {
            throw new BadRequestException("The booking operation is not possible for the charities you want.");
        }
        if (reserveRepository.charityReserved(charity.getId())) {
            throw new AlreadyExistsException("Charity with id %s already reserved.".formatted(charity.getId()));
        }
        boolean isAnonymous = reserveRequestCharity.isAnonymous();
        Reserve reserve = new Reserve();
        reserve.setUser(userInToken);
        reserve.setCharity(charity);
        reserve.setIsAnonymous(isAnonymous);
        charity.setStatus(true);
        charityRepository.save(charity);
        reserveRepository.save(reserve);

        Notification notification = Notification.builder()
                .reserve(reserve)
                .seen(false)
                .toWhomUser(charity.getUser())
                .fromWhomUser(userInToken)
                .createdAt(LocalDate.now())
                .build();
        if (isAnonymous) {
            notification.setType(Type.BOOKED_ANONYMOUSLY);
            notification.setMessage("%s было забронировано анонимным пользователем.".formatted(charity.getName()));
        } else {
            notification.setType(Type.BOOKED_NOT_ANONYMOUSLY);
            notification.setMessage("%s было забронировано пользователем %s %s".formatted(charity.getName(), userInToken.getLastName(), userInToken.getFirstName()));
        }
        notificationRepository.save(notification);

        log.info("Reserving charity with id {}", charity.getId());
        return ReserveSimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with  %s  id successfully reserved", reserveRequestCharity.charityId()))
                .build();
    }


    @Override
    public ReserveGetAllResponse getAllReserves() {
        log.info("Getting all reserves.");
        User user = jwtService.getUserInToken();
        return new ReserveGetAllResponse(reserveRepository.getAllReversesWish(user.getId()), reserveRepository.getAllReversesCharity(user.getId()));
    }

    @Transactional
    @Override
    public SimpleResponse addGiftToWish(Long wishId, Long holidayId) {
        User userInToken = jwtService.getUserInToken();
        Wish wish = wishRepository.findById(wishId).orElseThrow(
                () -> new NotFoundException(String.format("Wish with id %s not found", wishId)));

        Holiday holiday = holidayRepository.findById(holidayId)
                .orElseThrow(() -> new NotFoundException("Holiday with id [%s] not found".formatted(holidayId)));
        if (!userInToken.getHolidays().contains(holiday)) {
            return SimpleResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Holiday [%s] does not exist in your holidays".formatted(holidayId))
                    .build();
        }
        Wish newWish = new Wish();
        newWish.setName(wish.getName());
        newWish.setImage(wish.getImage());
        newWish.setDescription(wish.getDescription());
        newWish.setLinkGift(wish.getLinkGift());
        newWish.setStatus(false);
        newWish.setUser(userInToken);
        newWish.setHoliday(holiday);
        wishRepository.save(newWish);
        log.info("Adding gift to wish with id {} ", wishId);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message(String.format("Gift with id %s successfully added to wish from reserves", wishId))
                .build();
    }


    @Override
    public PaginationResponse getWishReservePagination(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ReserveResponseWish> pagedWishes = reserveRepository.getAll(pageable);
        log.info("Getting wish reserve pagination, page {} , size {}", page, size);
        return PaginationResponse.builder()
                .elements(Collections.singletonList(pagedWishes.getContent()))
                .pageSize(pagedWishes.getNumber() + 1)
                .currentPage(pagedWishes.getTotalPages())
                .build();
    }


    @Override
    public PaginationResponse getCharityReservePagination(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ReserveResponseCharity> pagedCharity = reserveRepository.getAllCharity(pageable);
        log.info("Getting charity reserve pagination, page {}, size {}", page, size);
        return PaginationResponse.builder()
                .elements(Collections.singletonList(pagedCharity.getContent()))
                .currentPage(pagedCharity.getTotalPages())
                .pageSize(pagedCharity.getNumber() + 1)
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
        if (!reserve.getUser().equals(user)) {
            throw new ForbiddenException("You are not authorized to delete this reserve");
        }
        wish.setStatus(false);
        wishRepository.save(wish);
        notificationRepository.deleteNotification(reserve.getId());
        reserveRepository.deleteWishReserve(reserve.getId());
        log.info("Deleting wish reserve for user {}", user.getId());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Reserve for user %s and wish %s has been deleted", user.getUsername(), wishId))
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
        if (!reserve.getUser().equals(user)) {
            throw new ForbiddenException("You are not authorized to delete this reserve");
        }
        charity.setStatus(false);
        charityRepository.save(charity);
        notificationRepository.deleteNotification(reserve.getId());
        reserveRepository.deleteWishReserve(reserve.getId());
        log.info("Deleting charity reserve for user {}", user.getId());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Reserve for user %s and wish %s has been deleted", user.getUsername(), charityId))
                .build();
    }
}



