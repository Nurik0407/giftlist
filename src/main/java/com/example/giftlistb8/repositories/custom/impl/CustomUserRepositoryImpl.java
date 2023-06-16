package com.example.giftlistb8.repositories.custom.impl;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseUser;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;
import com.example.giftlistb8.dto.wish.response.WishResponseUser;
import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.repositories.custom.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public PaginationResponse<UserResponseGetAll> getAllUsers(int size, int page) {
        String sql = """
                SELECT u.id as userId,
                ui.image as user_image,
                concat(u.first_name, ' ', u.last_name) as full_name,
                (SELECT COUNT(*) FROM wishes w WHERE w.user_id = u.id and w.is_blocked=false) as total_wishes,
                u.is_blocked as isBlocker
                FROM users u
                         JOIN user_infos ui on u.user_info_id = ui.id
                ORDER BY u.id DESC   \s
                """;
        String countSql = "SELECT COUNT(*) FROM (" + sql + ") as count_query";
        int count = jdbcTemplate.queryForObject(countSql, Integer.class);
        int totalCount = (int) Math.ceil((double) count / size);
        int offset = (page - 1) * size;
        sql = String.format(sql + "LIMIT %s OFFSET %s", size, offset);
        List<UserResponseGetAll> userResponse = jdbcTemplate.query(sql, (resultSet, i) -> new UserResponseGetAll(
                resultSet.getLong("userId"),
                resultSet.getString("user_image"),
                resultSet.getString("full_name"),
                resultSet.getInt("total_wishes"),
                resultSet.getBoolean("isBlocker")
        ));
        return PaginationResponse.<UserResponseGetAll>builder().elements(userResponse).currentPage(page).pageSize(totalCount).build();
    }


    @Override
    public UserResponseGetById getById(Long userId) {
        UserResponseGetById user = new UserResponseGetById();
        String sql = """
                select u.id as user_id,
                       concat(u.first_name, ' ', u.last_name) as full_name,
                       ui.image as image,
                       ui.phone_number as user_phone,
                   ui.date_of_birth as user_date_of_birth,
                       ui.country as country,
                       ui.hobby as hobby,
                       ui.important as important,
                       ui.clothing_size as clothing_size,
                       ui.shoe_size as  shoe_size,
                       ui.instagram as instagram,
                       ui.telegram as telegram,
                       ui.facebook as facebook,
                       ui.whats_app as whats_app,
                       u.email as user_email
                from users u
                       join user_infos ui on u.user_info_id = ui.id
                        where u.id = ?
                """;
        jdbcTemplate.query(sql, new Object[]{userId}, (resultSet, i) -> {
                    user.setId(resultSet.getLong("user_id"));
                    user.setFullName(resultSet.getString("full_name"));
                    user.setImage(resultSet.getString("image"));
                    user.setPhoneNumber(resultSet.getString("user_phone"));
                    user.setDateOfBirth(resultSet.getDate("user_date_of_birth").toLocalDate());
                    user.setCountry(resultSet.getString("country"));
                    user.setHobby(resultSet.getString("hobby"));
                    user.setImportant(resultSet.getString("important"));
                    user.setClothingSize(ClothingSize.valueOf(resultSet.getString("clothing_size")));
                    user.setShoeSize(resultSet.getString("shoe_size"));
                    user.setInstagram(resultSet.getString("instagram"));
                    user.setTelegram(resultSet.getString("telegram"));
                    user.setFacebook(resultSet.getString("facebook"));
                    user.setWhatsApp(resultSet.getString("whats_app"));
                    user.setEmail(resultSet.getString("user_email"));

                    return user;
                }
        );

        String query = """
                select w.id as wishId, 
                w.image as image, 
                w.name as wishName, 
                h.name as holidayName, 
                h.date as date_of_holiday, 
                w.status as wishStatus
                from wishes w
                         join holidays h on h.id = w.holiday_id
                         join users u on w.user_id = u.id 
                         where u.id = ? and w.is_blocked = false
                """;
        List<WishResponseUser> wishResponses = jdbcTemplate.query(query,new Object[]{userId},(resultSet, i)
                -> new WishResponseUser(
                resultSet.getLong("wishId"),
                resultSet.getString("image"),
                resultSet.getString("wishName"),
                resultSet.getString("holidayName"),
                resultSet.getDate("date_of_holiday").toLocalDate(),
                resultSet.getString("wishStatus")
        ));
        user.setWishResponseUserList(wishResponses);
        String query1 = """
                select 
                h.id as id,
                h.name as holidayName, 
                h.image as image, 
                h.date as holiday_date
                from holidays h
                join users u on h.user_id = u.id
                where u.id = ?;
                """;
        List<HolidayResponse> holidayResponses = jdbcTemplate.query(query1,new Object[]{userId},(resultSet, i)
                -> new HolidayResponse(
                resultSet.getLong("id"),
                resultSet.getString("holidayName"),
                resultSet.getString("image"),
                resultSet.getDate("holiday_date").toLocalDate()
        ));
        user.setHolidayResponses(holidayResponses);
        String query2 = """
                SELECT c.id as charityId,
                       c.image as image,
                       c.name as name,
                       c.state as state,
                       c.date_of_issue as date,
                       coalesce(case when r.is_anonymous = false then rui.image end ,null) as reserveUserPhoto,
                       c.status as isReserved
                FROM charities c
                         JOIN users u on u.id = c.user_id
                         LEFT JOIN reserves r on c.id = r.charity_id
                         LEFT JOIN users ru on r.user_id = ru.id
                         LEFT JOIN user_infos rui on ru.user_info_id = rui.id
                         where u.id = ? and c.is_blocked = false
                """;
        List<CharityResponseUser> charityResponseUsers = jdbcTemplate.query(query2,new Object[]{userId},(resultSet, i) -> new CharityResponseUser(
                resultSet.getLong("charityId"),
                resultSet.getString("image"),
                resultSet.getString("name"),
                resultSet.getString("state"),
                resultSet.getDate("date").toLocalDate(),
                resultSet.getString("reserveUserPhoto"),
                resultSet.getBoolean("isReserved")

        ));
        user.setCharityResponseUsers(charityResponseUsers);

        return user;
    }
}
