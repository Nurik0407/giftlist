package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.config.SimpleResponse;
import com.example.giftlistb8.dto.wish.requests.WishRequest;
import com.example.giftlistb8.dto.wish.responses.WishResponce;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.entities.Wish;
import com.example.giftlistb8.exceptions.NotFoundException;
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
    private final WishRepository repository;
    private final JwtService jwtService;
    @Override
    public List<WishResponce> findAll() {
        return repository.findAllWishes();
    }

    @Override
    public WishResponce getById(Long id) {
        Wish wish = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Restaurant with id: %s not found!", id)));
        repository.save(wish);

        return repository.findWishById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        String.format("Restaurant with id: %s not found!", id)));
    }

    @Override
    public SimpleResponse save(WishRequest request) {
        User user = jwtService.getUserInToken();
        Wish wish = Wish.builder()
                .name(request.name())
                .linkGift(request.linkGift())
                .dateOfHoliday(request.dateOfHoliday())
                .image(request.image())
                .description(request.descriptions())
                .build();
        wish.setUser(user);
        repository.save(wish);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Wish with name %s successfully saved.", wish.getName()))
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Wish wish = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Wish with id %s not found.", id)));
        User userInToken = jwtService.getUserInToken();
        userInToken.deleteWish(wish);
        repository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Wish with id %s successfully deleted.", id))
                .build();
    }

    @Override
    public SimpleResponse update(Long id, WishRequest request) {
        Wish wish = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Wish with id %s not found.", id)));
        wish.setName(request.name());
        wish.setLinkGift(request.linkGift());
        wish.setDateOfHoliday(request.dateOfHoliday());
        wish.setImage(request.image());
        wish.setDescription(request.descriptions());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Wish with name %s successfully updated.", id))
                .build();
    }
}
