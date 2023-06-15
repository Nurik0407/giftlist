package com.example.giftlistb8.repositories.custom.impl;

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
                select
                n.id as id,
                u.id as fromWhomUserId,
                concat(u.last_name,' ',u.first_name) as fromWhomUserFullName,
                COALESCE(w.name,COALESCE(w1.name,null)) as wishName,
                COALESCE(w.id,COALESCE(w1.id,null)) as wishId,
                COALESCE(c.name,COALESCE(c1.name,null)) as charityName,
                COALESCE(c.id,COALESCE(c1.id,null)) as charityId,
                ui.image as image,
                n.type as type,
                n.message as message,
                n.seen as seen,
                n.created_at as createdAt 
                FROM notifications n 
                JOIN users towhomuser on towhomuser.id = n.to_whom_user_id
                JOIN users u on u.id = n.from_whom_user_id 
                JOIN user_infos ui on u.user_info_id = ui.id
                LEFT JOIN reserves r on n.reserve_id = r.id
                LEFT JOIN wishes w on r.wish_id = w.id
                LEFT JOIN charities c on r.charity_id = c.id
                LEFT JOIN wishes w1 on n.wish_id = w1.id
                LEFT JOIN charities c1 on n.charity_id = c1.id
                WHERE towhomuser.id = ? AND n.type NOT IN ('COMPLAINT')
                ORDER BY n.id DESC;
                """;


        return jdbcTemplate.query(sql, (resultSet, i) ->
             new NotificationResponse(
                     resultSet.getLong("id"),
                    resultSet.getLong("fromWhomUserId"),
                     resultSet.getString("fromWhomUserFullName"),
                     resultSet.getString("wishName"),
                     resultSet.getLong("wishId"),
                     resultSet.getString("charityName"),
                     resultSet.getLong("charityId"),
                     resultSet.getString("image"),
                    resultSet.getString("type"),
                    resultSet.getString("message"),
                     resultSet.getBoolean("seen"),
                     resultSet.getDate("createdAt").toLocalDate()
            ),userId
        );
    }

    @Override
    public List<NotificationResponse> getAllComplaintNotifications() {
        String sql = """
                select
                n.id as id,
                u.id as fromWhomUserId,
                concat(u.last_name,' ',u.first_name) as fromWhomUserFullName,
                COALESCE(w.name,null) as wishName,
                COALESCE(w.id,null) as wishId,
                COALESCE(c.name,null) as charityName,
                COALESCE(c.id,null) as charityId,
                ui.image as image,
                n.type as type,
                n.message as message,
                n.seen as seen,
                n.created_at as createdAt
                FROM notifications n
                JOIN users towhomuser on towhomuser.id = n.to_whom_user_id
                JOIN users u on u.id = n.from_whom_user_id
                JOIN user_infos ui on u.user_info_id = ui.id
                LEFT JOIN wishes w on n.wish_id = w.id
                LEFT JOIN charities c on n.charity_id = c.id
                WHERE n.type IN ('COMPLAINT')
                ORDER BY n.id DESC;
                """;


        return jdbcTemplate.query(sql, (resultSet, i) ->
                new NotificationResponse(
                        resultSet.getLong("id"),
                        resultSet.getLong("fromWhomUserId"),
                        resultSet.getString("fromWhomUserFullName"),
                        resultSet.getString("wishName"),
                        resultSet.getLong("wishId"),
                        resultSet.getString("charityName"),
                        resultSet.getLong("charityId"),
                        resultSet.getString("image"),
                        resultSet.getString("type"),
                        resultSet.getString("message"),
                        resultSet.getBoolean("seen"),
                        resultSet.getDate("createdAt").toLocalDate()
                )
        );
    }
}

