package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.feed.response.FeedResponse;
import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.feed.response.FeedResponseGetById;
import com.example.giftlistb8.exceptions.DataLockedException;
import com.example.giftlistb8.services.FeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FeedServiceImpl implements FeedService {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public PaginationResponse<FeedResponse> getAll(int page, int size) {
        log.info("Fetching feed with page {} and size {}", page, size);
        String sql = """
                SELECT u.id as userId,
                       ui.image as image,
                       concat(u.first_name, ' ', u.last_name) as fullName,
                       w.id as wishId,
                       w.name as wishName,
                       w.image as wishImage,
                       w.status as isReserved,
                       h.date as holidayDate,
                       h.name as holidayName,
                       COALESCE(CASE WHEN r.is_anonymous = false THEN rui.image END, null) as reserveUserPhoto,
                       COALESCE(r.is_anonymous, false) AS is_anonymous
                    FROM
                       wishes w
                       JOIN users u on u.id = w.user_id
                       JOIN user_infos ui on u.user_info_id = ui.id
                       JOIN holidays h on w.holiday_id = h.id
                       LEFT JOIN reserves r on r.wish_id = w.id
                       LEFT JOIN users ru on r.user_id = ru.id
                       LEFT JOIN user_infos rui on ru.user_info_id = rui.id
                     WHERE 
                         w.is_blocked=false
                     ORDER BY 
                         u.id DESC\s
                """;
        String countSql = "SELECT COUNT(*) FROM (" + sql + ") as count_query";
        int count = jdbcTemplate.queryForObject(countSql, Integer.class);
        int totalCount = (int) Math.ceil((double) count / size);
        int offset = (page - 1) * size;
        sql = sql + "LIMIT " + size + " OFFSET "+offset;
        List<FeedResponse> feedResponses = jdbcTemplate.query(sql, (resultSet, i) -> new FeedResponse(
                resultSet.getLong("userId"),
                resultSet.getString("image"),
                resultSet.getString("fullName"),
                resultSet.getString("holidayName"),
                resultSet.getLong("wishId"),
                resultSet.getString("wishName"),
                resultSet.getString("wishImage"),
                resultSet.getDate("holidayDate").toLocalDate(),
                resultSet.getBoolean("isReserved"),
                resultSet.getBoolean("is_anonymous"),
                resultSet.getString("reserveUserPhoto")
        ));
        log.info("Fetched feed with {} elements", feedResponses.size());
        return PaginationResponse.<FeedResponse>builder().elements(feedResponses).currentPage(page).pageSize(totalCount).build();
    }

    @Override
    public FeedResponseGetById getById(Long wishId) {
        String isBlocked = """
                select w.is_blocked from wishes w
                where w.id = ?
                """;
        Boolean result = jdbcTemplate.queryForObject(isBlocked, Boolean.class,wishId);

        if (result != null ? result : false){
            throw new DataLockedException("Data locked.");
        }

        String sql = """
                SELECT u.id AS userId,
                       ui.image AS image,
                       concat(u.first_name, ' ', u.last_name) AS fullName,
                       w.name AS wishName,
                       w.image AS wishImage,
                       w.status AS status,
                       w.description AS wishDescription,
                       h.date AS holidayDate,
                       h.name AS holidayName,
                       COALESCE(CASE WHEN r.is_anonymous = FALSE THEN rui.image END, NULL) AS reserveUserPhoto,
                       COALESCE(r.is_anonymous, FALSE) AS is_anonymous
                FROM 
                        wishes w 
                        JOIN users u ON u.id = w.user_id
                        JOIN user_infos ui ON u.user_info_id = ui.id
                        JOIN holidays h ON w.holiday_id = h.id
                        LEFT JOIN reserves r ON r.wish_id = w.id
                        LEFT JOIN users ru ON r.user_id = ru.id
                        LEFT JOIN user_infos rui ON rui.id = ru.user_info_id
                WHERE 
                        w.id = ? AND w.is_blocked = FALSE;
                """;

        Object[] args = {wishId};
        log.debug("Searching for charity with id {}...", wishId);
        FeedResponseGetById feedResponseGetById = jdbcTemplate.queryForObject(sql, args, (resultSet, i)
                -> new FeedResponseGetById(
                resultSet.getLong("userId"),
                resultSet.getString("image"),
                resultSet.getString("fullName"),
                resultSet.getString("holidayName"),
                resultSet.getString("wishName"),
                resultSet.getString("wishDescription"),
                resultSet.getString("wishImage"),
                resultSet.getDate("holidayDate").toLocalDate(),
                resultSet.getBoolean("status"),
                resultSet.getBoolean("is_anonymous"),
                resultSet.getString("reserveUserPhoto")));

        return feedResponseGetById;
    }
}
