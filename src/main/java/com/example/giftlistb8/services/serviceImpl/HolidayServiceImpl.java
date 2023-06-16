package com.example.giftlistb8.services.serviceImpl;


import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.holiday.request.HolidayRequest;
import com.example.giftlistb8.dto.holiday.response.GlobalSearchHoliday;
import com.example.giftlistb8.dto.holiday.response.HolidayByIdResponse;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.entities.Holiday;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.HolidayRepository;
import com.example.giftlistb8.repositories.WishRepository;
import com.example.giftlistb8.repositories.custom.HolidayRepositoryCustom;
import com.example.giftlistb8.services.HolidayService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class HolidayServiceImpl implements HolidayService {
    private final WishRepository wishRepository;
    private final HolidayRepository repository;
    private final JwtService jwtService;
    private final JdbcTemplate jdbcTemplate;
    private final HolidayRepositoryCustom holidayRepositoryCustom;

    @Override
    public List<HolidayResponse> findAll() {
        User user = jwtService.getUserInToken();
        String sql = "SELECT h.id,h.name, h.image, h.date FROM holidays h JOIN users u ON h.user_id = u.id WHERE u.email = ? ORDER BY h.id DESC ";
        List<HolidayResponse> holidays = jdbcTemplate.query(sql, new Object[]{user.getEmail()}, (rs, rowNum) ->
                new HolidayResponse(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getDate("date").toLocalDate()));
        log.info("Find all holidays for user: " + user.getEmail());
        return holidays;
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
        log.info("Holiday with name {} successfully saved.", holiday.getName());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Holiday with name %s successfully saved.", holiday.getName()))
                .build();
    }

    @Override
    public SimpleResponse update(Long id, HolidayRequest request) {
        String sql = "UPDATE holidays SET name=?,image=?,date=? WHERE id=?";
        jdbcTemplate.update(sql, request.name(), request.image(), request.dateOfHoliday(), id);
        log.info("Holiday with id {} successfully updated.", id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Holiday with name %s successfully updated.", id))
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {

        Holiday holiday = repository.findById(id).orElseThrow(() -> {
            log.error("Holiday with id {} not found.", id);
            return new NotFoundException(String.format("Holiday with id %s not found.", id));});

        User userInToken = jwtService.getUserInToken();
        if (!userInToken.getHolidays().contains(holiday)) {
            throw new BadRequestException(
                    String.format("The holiday with id %s cannot be deleted as it does not belong to the current user.", id));
        }

        userInToken.deleteHoliday(holiday);
        wishRepository.updateFromHoliday(userInToken.getId());
        repository.deleteHoliday(id);

        log.info("Holiday with id {} successfully deleted.", id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Holiday with id %s successfully deleted.", id))
                .build();
    }

    @Override
    public HolidayByIdResponse getById(Long id) {
        return holidayRepositoryCustom.getById(id);
    }

    @Override
    public List<GlobalSearchHoliday> globalSearch(String keyWord) {
        return repository.globalSearch(keyWord);
    }
}
