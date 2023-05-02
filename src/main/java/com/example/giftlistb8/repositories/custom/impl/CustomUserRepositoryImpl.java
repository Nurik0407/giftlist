package com.example.giftlistb8.repositories.custom.impl;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseUser;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;
import com.example.giftlistb8.dto.wish.response.WishResponseUser;
import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import com.example.giftlistb8.repositories.custom.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {
    private  final JdbcTemplate jdbcTemplate;
    @Override
    public PaginationResponse<UserResponseGetAll> getAllUsers(int size, int page) {
        String sql= """
                SELECT u.id, ui.image, concat(u.first_name, ' ', u.last_name) as full_name,
                       (SELECT COUNT(*) FROM wishes w WHERE w.user_id = u.id) as total_wishes
                FROM users u
                         JOIN user_infos ui ON u.id = ui.user_id
                """;
        return null;
    }

    @Override
    public UserResponseGetById getById(Long userId) {
        UserResponseGetById user = new UserResponseGetById();
        String sql = """
                select u.id as user_id,
                       concat(u.first_name, ' ', u.last_name) as full_name,
                       ui.phone_number as user_phone,
                       u.email as user_email,
                       ui.date_of_birth as user_date_of_birth,
                       ui.country as country,
                       ui.hobby as hobby,
                       ui.important as important,
                       ui.clothing_size as clothing_size,
                       ui.shoe_size as  shoe_size,
                       ui.instagram as instagram,
                       ui.telegram as telegram,
                       ui.facebook as facebook,
                       ui.whats_app as what_app
                from users u
                         join user_infos ui on u.id = ui.user_id where u.id = ?
                """;
        jdbcTemplate.query(sql, new Object[]{userId}, (resultSet, i) -> {
                    user.setId(resultSet.getLong("user_id"));
                    user.setFullName(resultSet.getString("full_name"));
                    user.setPhoneNumber(resultSet.getString("user_phone"));
                    user.setDateOfBirth(resultSet.getDate("user_date_of_birth").toLocalDate());
                    user.setCountry(resultSet.getString("country"));
                    user.setHobby(resultSet.getString("hobby"));
                    user.setImportant(resultSet.getString("important"));
                    user.setClothingSize(ClothingSize.valueOf(resultSet.getString("ClothingSize")));
                    user.setShoeSize(ShoeSize.valueOf(resultSet.getString("shoe_size")));
                    user.setInstagram(resultSet.getString("instagram"));
                    user.setTelegram(resultSet.getString("telegram"));
                    user.setFacebook(resultSet.getString("facebook"));
                    user.setWhatsApp(resultSet.getString("what_app"));
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
                """;
        List<WishResponseUser> wishResponses = jdbcTemplate.query(query, (resultSet, i) -> new WishResponseUser(
                resultSet.getLong("id"),
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
                from holidays h;
                """;
        List<HolidayResponse> holidayResponses = jdbcTemplate.query(query1, (resultSet, i) -> new HolidayResponse(
                resultSet.getLong("id"),
                resultSet.getString("holidayName"),
                resultSet.getString("image"),
                resultSet.getDate("holiday_date").toLocalDate()
        ));
        user.setHolidayResponses(holidayResponses);
        String query2 = """
                SELECT ch.id as charityId,
                       ch.image as image,
                       ch.name as name,
                       ch.state as state,
                       h.date,
                       coalesce((select ui.image
                                 from reserves r
                                          join users u2 on r.user_id = u2.id and w.id = r.wish_id
                                 where is_anonymous is false), NULL) as reserveUserPhoto,
                       CASE WHEN r.charity_id IS NULL THEN FALSE ELSE TRUE END AS is_reserved
                FROM charities ch
                         JOIN holidays h ON ch.user_id = h.user_id
                         JOIN reserves r ON ch.id = r.charity_id
                         JOIN users u on u.id = ch.user_id
                         JOIN user_infos ui on u.id = ui.user_id
                         JOIN wishes w on u.id = w.user_id;
                """;
        List<CharityResponseUser> charityResponseUsers = jdbcTemplate.query(query2, (resultSet, i) -> new CharityResponseUser(
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
