package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.request.CharityRequest;
import com.example.giftlistb8.dto.charity.request.CharityUpdateRequest;
import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.entities.Charity;
import com.example.giftlistb8.entities.Notification;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.enums.Type;
import com.example.giftlistb8.exceptions.BadRequestException;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.CharityRepository;
import com.example.giftlistb8.repositories.NotificationRepository;
import com.example.giftlistb8.services.CharityService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CharityServiceImpl implements CharityService {
    private final CharityRepository repository;
    private final JdbcTemplate jdbcTemplate;
    private final JwtService jwtService;
    private final NotificationRepository notificationRepository;


    @Override
    public SimpleResponse save(CharityRequest request) {
        User userInToken = jwtService.getUserInToken();
        Charity charity = Charity.builder()
                .name(request.name())
                .state(request.state())
                .description(request.description())
                .category(request.category())
                .subCategory(request.subCategory())
                .image(request.image())
                .dateOfIssue(LocalDate.now())
                .user(userInToken)
                .status(false)
                .build();
        repository.save(charity);

        List<User> friends = userInToken.getFriends();
        List<Notification> notifications = friends.stream()
                .map(friend -> Notification.builder()
                        .charity(charity)
                        .type(Type.ADD_GIFT_TO_WISH_LIST)
                        .message(" добавил(а-) новый благотворительность")
                        .seen(false)
                        .fromWhomUser(userInToken)
                        .toWhomUser(friend)
                        .createdAt(LocalDate.now())
                        .build()).toList();
        notificationRepository.saveAll(notifications);

        log.info("Charity with name {} successfully saved by user {}", charity.getName(), userInToken.getId());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with name %s successfully saved.", charity.getName()))
                .build();
    }

    @Override
    public List<CharitiesResponse> findAll() {
        String sql = "SELECT u.id as user_id,CONCAT(u.last_name, ',', u.first_name) AS full_name,ui.image,c.id,c.name, c.image, c.date_of_issue,c.state, (case when r.id is null then false else true end) as is_reserved, COALESCE(r.is_anonymous, false) AS is_anonymous " +
                "FROM charities c " +
                "JOIN users u ON c.user_id = u.id " +
                "LEFT JOIN user_infos ui ON u.user_info_id = ui.id " +
                "LEFT JOIN reserves r ON c.id = r.charity_id ORDER BY c.id DESC ";
        List<CharitiesResponse> charitiesResponses = jdbcTemplate.query(sql, (rs, rowNum) -> new CharitiesResponse(
                rs.getLong("user_id"),
                rs.getString("full_name"),
                rs.getString("image"),
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("image"),
                rs.getDate("date_of_issue").toLocalDate(),
                rs.getString("state"),
                rs.getBoolean("is_reserved"),
                rs.getBoolean("is_anonymous")));
        log.debug("Found {} charities.", charitiesResponses.size());
        return charitiesResponses;
    }

    @Override
    public SimpleResponse update(CharityUpdateRequest request) {
        jdbcTemplate.update("update charities set name=?,state=?,description=?,category=?,sub_category=?,image=? WHERE id=?",
                request.name(), request.state(), request.description(), request.category(), request.subCategory(), request.image(), request.id());
        log.info("Charity with id {} successfully updated.", request.id());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with id %s successfully updated.", request.id()))
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {

        User userInToken = jwtService.getUserInToken();
        Charity charity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Charity with id %s not found.".formatted(id)));

        if (!userInToken.getCharities().contains(charity)){
            throw new BadRequestException("Благотворительность не принадлежит текущему пользователю.");
        }
        userInToken.deleteCharity(charity);
        repository.deleteFromReserve(id);
        repository.deleteFromNotifications(id);
        repository.deleteFromCharityComplaints(id);
        notificationRepository.deleteFromCharity(id);
        repository.deleteCharity(id);

        log.info("Charity with id {} successfully deleted",id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with id %s successfully deleted.", id))
                .build();
    }

    @Override
    public CharityResponse findById(Long id) {
        log.debug("Searching for charity with id {}...", id);
        CharityResponse charityResponse = repository.findCharityById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Charity with id %s not found.", id)));
        log.debug("Found charity with id {}: {}", id, charityResponse);
        return charityResponse;
    }
}
