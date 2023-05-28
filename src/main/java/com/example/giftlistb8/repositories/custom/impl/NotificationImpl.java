package com.example.giftlistb8.repositories.custom.impl;

import com.example.giftlistb8.config.JwtService;
import com.example.giftlistb8.dto.notification.response.NotificationResponse;
import com.example.giftlistb8.repositories.custom.NotificationRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class NotificationImpl implements NotificationRepositoryCustom {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<NotificationResponse> getAll(Long userId) {
        String sql = """
                select u.id as fromWhomUserId,
                ui.image as image,
                concat(u.first_name,' ',u.last_name) as fullName,
                n.type as type,
                n.message as message,
                n.created_at as createdAt 
                from notifications n 
                join users towhomuser on towhomuser.id = n.to_whom_user_id
                join users u on u.id = n.from_whom_user_id 
                join user_infos ui on u.user_info_id = ui.id 
                where towhomuser.id = ?;
                """;


        return jdbcTemplate.query(sql, (resultSet, i) ->
             new NotificationResponse(
                    resultSet.getLong("fromWhomUserId"),
                    resultSet.getString("fullName"),
                     resultSet.getString("image"),
                    resultSet.getString("type"),
                    resultSet.getString("message"),
                     resultSet.getDate("createdAt").toLocalDate()
            ),userId
        );
    }
}

