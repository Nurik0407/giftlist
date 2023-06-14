package com.example.giftlistb8.repositories.custom.impl;

import com.example.giftlistb8.dto.holiday.response.HolidayByIdResponse;
import com.example.giftlistb8.dto.wish.responses.WishResponse;
import com.example.giftlistb8.repositories.custom.HolidayRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HolidayRepositoryCustomImpl implements HolidayRepositoryCustom {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public HolidayByIdResponse getById(Long id) {

        String getWishesByHolidayId = """
                SELECT w.id as id,w.name as name,w.image as image,w.date_of_holiday as date,
                w.status as isReserved,r.is_anonymous as isAnonymous,
                COALESCE(case when r.is_anonymous = false then ui.image end,null) as reserveUserImage
                FROM wishes w
                JOIN holidays h on w.holiday_id = h.id
                LEFT JOIN reserves r on w.id = r.wish_id
                LEFT JOIN users u on r.user_id = u.id
                LEFT JOIN user_infos ui on u.user_info_id = ui.id
                WHERE h.id = ? and w.is_blocked = false ORDER BY w.id DESC
                """;

        List<WishResponse> wishesByHolidayId = jdbcTemplate.query(getWishesByHolidayId, new Object[]{id}, (resultSet, i) -> new WishResponse(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("holidayName"),
                resultSet.getString("image"),
                resultSet.getDate("date").toLocalDate(),
                resultSet.getBoolean("isReserved"),
                resultSet.getBoolean("isAnonymous"),
                resultSet.getString("reserveUserImage")
        ));

        String getHolidayById = """
                SELECT h.id as id,h.name as name FROM holidays h WHERE h.id = ?
                """;

        return jdbcTemplate.queryForObject(getHolidayById, new Object[]{id}, (resultset, i) -> new HolidayByIdResponse(
                resultset.getLong("id"),
                resultset.getString("name"),
                wishesByHolidayId
        ));
    }
}
