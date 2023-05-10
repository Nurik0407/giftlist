package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.repositories.CharityRepository;
import com.example.giftlistb8.services.CharityAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CharityAdminServiceImpl implements CharityAdminService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CharitiesResponse> findAll() {
        String sql = "SELECT u.id as user_id,CONCAT(u.last_name, ',', u.first_name) AS full_name, ui.image,"+
                "c.id,c.name, c.image, c.date_of_issue,c.state,case when r.id = null then false else true end  AS is_reserved, COALESCE(r.is_anonymous, false) AS is_anonymous " +
                "FROM charities c " +
                "JOIN users u ON c.user_id = u.id " +
                "LEFT JOIN user_infos ui ON u.user_info_id = ui.id " +
                "LEFT JOIN reserves r ON c.id = r.charity_id";
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
}
