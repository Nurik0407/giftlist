package com.example.giftlistb8.services.serviceImpl;

import com.example.giftlistb8.dto.feed.response.FeedResponse;
import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.feed.response.FeedResponseGetById;
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
                       w.name as wishName,
                       w.image as wishImage,
                       w.status as status,
                       h.date as holidayDate,
                       h.name as holidayName,
                       coalesce((select ui.image
                                 from reserves r
                                          join users u2 on r.user_id = u2.id and w.id = r.wish_id
                                 where is_anonymous is false),
                                null )  as reserveUserPhoto
                FROM users u
                         Join wishes w on u.id = w.user_id
                         Join user_infos ui on u.user_info_id = ui.id
                         JOIN holidays h ON u.id = h.user_id and w.holiday_id = h.id
                         where w.is_blocked=false
                         ORDER BY u.id DESC 
                """;
        String countSql = "SELECT COUNT(*) FROM (" + sql + ") as count_query";
        int count = jdbcTemplate.queryForObject(countSql, Integer.class);
        int totalCount = (int) Math.ceil((double) count / size);
        int offset = (page - 1) * size;
        sql = String.format(sql + "LIMIT %s OFFSET %s", size, offset);
        List<FeedResponse> feedResponses = jdbcTemplate.query(sql, (resultSet, i) -> new FeedResponse(resultSet.getLong("userId"),resultSet.getString("image"), resultSet.getString("fullName"), resultSet.getString("holidayName"), resultSet.getString("wishName"), resultSet.getString("wishImage"), resultSet.getDate("holidayDate").toLocalDate(), resultSet.getBoolean("status"), resultSet.getString("reserveUserPhoto")

        ));
        log.info("Fetched feed with {} elements", feedResponses.size());
        return PaginationResponse.<FeedResponse>builder().elements(feedResponses).currentPage(page).pageSize(totalCount).build();
    }

    @Override
    public FeedResponseGetById getById(Long wishId) {
        String sql = """
                SELECT u.id as userId,
                       ui.image as image,
                       concat(u.first_name, ' ', u.last_name) as fullName,
                       w.name as wishName,
                       w.image as wishImage,
                       w.status as status,
                       w.description as wishDescription,
                       h.date as holidayDate,
                       h.name as holidayName,
                        coalesce((select ui.image
                                 from reserves r
                                          join users u2 on r.user_id = u2.id and w.id = r.wish_id
                                 where is_anonymous is false),
                                null ) as reserveUserPhoto
                FROM users u
                         Join wishes w on u.id = w.user_id
                         Join user_infos ui on u.user_info_id = ui.id
                         JOIN holidays h ON u.id = h.user_id and w.holiday_id = h.id where w.id=? and w.is_blocked=false;
                """;

        Object[] args = {wishId};
        log.debug("Searching for charity with id {}...", wishId);
        return jdbcTemplate.queryForObject(sql, args, (resultSet, i) -> new FeedResponseGetById(resultSet.getLong("userId"),resultSet.getString("image"), resultSet.getString("fullName"), resultSet.getString("holidayName"), resultSet.getString("wishName"),resultSet.getString("wishDescription") ,resultSet.getString("wishImage"), resultSet.getDate("holidayDate").toLocalDate(), resultSet.getBoolean("status"), resultSet.getString("reserveUserPhoto")));
    }
}
