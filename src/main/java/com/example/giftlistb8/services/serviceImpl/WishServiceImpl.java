package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.wish.requests.WishRequest;
import com.example.giftlistb8.dto.wish.responses.WishResponse;
import com.example.giftlistb8.entities.Holiday;
import com.example.giftlistb8.entities.Notification;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.entities.Wish;
import com.example.giftlistb8.enums.Type;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.HolidayRepository;
import com.example.giftlistb8.repositories.NotificationRepository;
import com.example.giftlistb8.repositories.WishRepository;
import com.example.giftlistb8.services.WishService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class WishServiceImpl implements WishService {
    private final HolidayRepository holidayRepository;
    private final WishRepository wishRepository;
    private final JwtService jwtService;
    private final NotificationRepository notificationRepository;

    @Override
    public List<WishResponse> findAll() {
        log.info("Finding all wishes");
        User user = jwtService.getUserInToken();
        return wishRepository.findAllWishes(user.getId());
    }

    @Override
    public WishResponse getById(Long id) {
        log.info("Finding wish by id: {}", id);
        Wish wish = wishRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Restaurant with id: %s not found!", id)));
        wishRepository.save(wish);

        return wishRepository.findWishById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Restaurant with id: %s not found!", id)));
    }

    @Override
    public SimpleResponse save(WishRequest request) {
        User user = jwtService.getUserInToken();
        Holiday holiday = holidayRepository.findById(request.holidayId()).orElseThrow(() -> new NotFoundException("Holiday not found!"));
        Wish wish = Wish.builder()
                .name(request.name())
                .linkGift(request.linkGift())
                .dateOfHoliday(request.dateOfHoliday())
                .image(request.image())
                .holiday(holiday)
                .user(user)
                .description(request.descriptions())
                .build();
        wishRepository.save(wish);

        List<User> friends = user.getFriends();
        List<Notification> notifications = friends.stream()
                .map(friend -> Notification.builder()
                        .type(Type.ADD_GIFT_TO_WISH_LIST)
                        .message(String.format("%s %s добавил новый желаемый подарок", user.getLastName(),user.getFirstName()))
                        .seen(false)
                        .fromWhomUser(user)
                        .toWhomUser(friend)
                        .build()).toList();
        notificationRepository.saveAll(notifications);

        log.info("Saving wish with name: {}", request.name());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Wish with name %s successfully saved.", wish.getName()))
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Wish wish = wishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Wish with id %s not found.", id)));
        User userInToken = jwtService.getUserInToken();
        userInToken.deleteWish(wish);
        wishRepository.deleteById(id);
        log.info("Deleting wish with id: {}", id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Wish with id %s successfully deleted.", id))
                .build();
    }

    @Override
    public SimpleResponse update(Long id, WishRequest request) {
        Wish wish = wishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Wish with id %s not found.", id)));
        wish.setName(request.name());
        wish.setLinkGift(request.linkGift());
        wish.setDateOfHoliday(request.dateOfHoliday());
        wish.setImage(request.image());
        wish.setDescription(request.descriptions());
        wishRepository.save(wish);
        log.info("Updating wish with id: {}", id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Wish with name %s successfully updated.", id))
                .build();
    }
}
