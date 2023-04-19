package com.example.giftlistb8.services.serviceImpl;


import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.holiday.request.HolidayRequest;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.entities.Holiday;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.HolidayRepository;
import com.example.giftlistb8.services.HolidayService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HolidayServiceImpl implements HolidayService {
    private final HolidayRepository repository;
    private final JwtService jwtService;

    @Override
    public List<HolidayResponse> findAll() {
        User user = jwtService.getUserInToken();
        return repository.getHolidaysByUserEmail(user.getEmail());
    }

    @Override
    public SimpleResponse save(HolidayRequest request) {
        User user = jwtService.getUserInToken();
        Holiday holiday = Holiday.builder()
                .name(request.name())
                .image(request.image())
                .date(request.dateOfHoliday())
                .build();
        holiday.setUser(user);
        repository.save(holiday);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Holiday with name %s successfully saved.", holiday.getName()))
                .build();
    }

    @Override
    public SimpleResponse update(Long id, HolidayRequest request) {
        Holiday oldHoliday = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Holiday with id %s not found.", id)));
        oldHoliday.setName(request.name());
        oldHoliday.setImage(request.image());
        oldHoliday.setDate(request.dateOfHoliday());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Holiday with name %s successfully updated.", id))
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Holiday holiday = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Holiday with id %s not found.", id)));
        User userInToken = jwtService.getUserInToken();
        userInToken.deleteHoliday(holiday);
        repository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Holiday with id %s successfully deleted.", id))
                .build();
    }
}
