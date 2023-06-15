package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.request.CharityRequest;
import com.example.giftlistb8.dto.charity.request.CharityUpdateRequest;
import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.entities.Charity;
import com.example.giftlistb8.entities.User;
import com.example.giftlistb8.exceptions.NotFoundException;
import com.example.giftlistb8.repositories.CharityRepository;
import com.example.giftlistb8.repositories.NotificationRepository;
import com.example.giftlistb8.services.CharityAdminService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CharityAdminServiceImpl implements CharityAdminService {
    private final JdbcTemplate jdbcTemplate;
    private final CharityRepository charityRepository;
    private final JwtService jwtService;
    private final NotificationRepository notificationRepository;

    @Override
    public List<CharitiesResponse> findAll() {
        String sql = "SELECT u.id as user_id,CONCAT(u.last_name, ' ', u.first_name) AS full_name, ui.image," +
                "c.id,c.name, c.image, c.date_of_issue,c.state,case when r.id = null then false else true end  AS is_reserved, COALESCE(r.is_anonymous, false) AS is_anonymous " +
                "FROM charities c " +
                "JOIN users u ON c.user_id = u.id " +
                "LEFT JOIN user_infos ui ON u.user_info_id = ui.id " +
                "LEFT JOIN reserves r ON c.id = r.charity_id ORDER BY c.id DESC ";
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> new CharitiesResponse(
                resultSet.getLong("user_id"),
                resultSet.getString("full_name"),
                resultSet.getString("image"),
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("image"),
                resultSet.getDate("date_of_issue").toLocalDate(),
                resultSet.getString("state"),
                resultSet.getBoolean("is_reserved"),
                resultSet.getBoolean("is_anonymous")));
    }

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
                .build();
        charityRepository.save(charity);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with name %s successfully saved.", charity.getName()))
                .build();
    }

    @Override
    public SimpleResponse update(CharityUpdateRequest request) {
        jdbcTemplate.update("update charities set name=?,state=?,description=?,category=?,sub_category=?,image=? WHERE id=?",
                request.name(), request.state(), request.description(), request.category(), request.subCategory(), request.image(), request.id());
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with id %s successfully updated.", request.id()))
                .build();
    }

    @Override
    public CharityResponse findById(Long id) {
        return charityRepository.findCharityById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Charity with id %s not found.", id)));
    }

    @Override
    public SimpleResponse delete(Long id) {

        User userInToken = jwtService.getUserInToken();
        Charity charity = charityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Charity with id %s not found.".formatted(id)));

        userInToken.deleteCharity(charity);
        charityRepository.deleteFromReserve(id);
        charityRepository.deleteFromNotifications(id);
        charityRepository.deleteFromCharityComplaints(id);
        notificationRepository.deleteFromCharity(id);
        charityRepository.deleteCharity(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with id %s successfully deleted.", id))
                .build();
    }
}
