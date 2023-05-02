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
import com.example.giftlistb8.services.CharityService;
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
public class CharityServiceImpl implements CharityService {
    private final CharityRepository repository;
    private final JdbcTemplate jdbcTemplate;
    private final JwtService jwtService;


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
        repository.save(charity);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with name %s successfully saved.", charity.getName()))
                .build();
    }

    @Override
    public List<CharitiesResponse> findAll() {
        String sql = "SELECT  c.id,CONCAT(u.last_name, ',', u.first_name) AS full_name, c.name, c.image, c.date_of_issue, case when r.id = null then false else true end  AS is_reserved, COALESCE(r.is_anonymous, false) AS is_anonymous " +
                "FROM charities c " +
                "JOIN users u ON c.user_id = u.id " +
                "LEFT JOIN reserves r ON c.id = r.charity_id";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new CharitiesResponse(
                rs.getLong("id"),
                rs.getString("full_name"),
                rs.getString("name"),
                rs.getString("image"),
                rs.getDate("date_of_issue").toLocalDate(),
                rs.getBoolean("is_reserved"),
                rs.getBoolean("is_anonymous")));
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
    public SimpleResponse delete(Long id) {
        User userInToken = jwtService.getUserInToken();
        Charity charity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Charity with id %s not found.", id)));
        userInToken.deleteCharity(charity);
        repository.deleteById(id);
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Charity with id %s successfully deleted.", id))
                .build();
    }

    @Override
    public CharityResponse findById(Long id) {
        return repository.findCharityById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("Charity with id %s not found.", id)));
    }
}
