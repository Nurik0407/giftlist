package com.example.giftlistb8.repositories.custom.impl;

import com.example.giftlistb8.dto.PaginationResponse;
import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponseUser;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.dto.user.response.UserResponseGetAll;
import com.example.giftlistb8.dto.user.response.UserResponseGetById;
import com.example.giftlistb8.dto.wish.response.WishResponseUser;
import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.repositories.custom.CustomUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
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
                       (SELECT COUNT(*) FROM wishes w WHERE w.user_id = u.id and w.is_blocked=false) as total_wishes
                FROM users u
                         JOIN user_infos ui on u.user_info_id = ui.id
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
                resultSet.getInt("total_wishes")

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
                         join user_infos ui on u.user_info_id = ui.id where u.id = ?
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
                         join holidays h on h.id = w.holiday_id where w.is_blocked=false
                """;
        List<WishResponseUser> wishResponses = jdbcTemplate.query(query, (resultSet, i) -> new WishResponseUser(
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
                       CASE WHEN r.charity_id IS NULL THEN FALSE ELSE TRUE END AS isReserved
                FROM charities ch
                         JOIN holidays h ON ch.user_id = h.user_id
                         JOIN reserves r ON ch.id = r.charity_id
                         JOIN users u on u.id = ch.user_id
                         JOIN user_infos ui on u.user_info_id = ui.id
                         JOIN wishes w on u.id = w.user_id where ch.is_blocked=false
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

    @Transactional
    @Override
    public SimpleResponse deleteById(Long userId) {
        try {

            String updateReservesSql = "UPDATE reserves SET charity_id = NULL, wish_id = NULL WHERE charity_id IN (SELECT id FROM charities WHERE user_id = ?) OR wish_id IN (SELECT id FROM wishes WHERE user_id = ?) OR user_id = ?";
            jdbcTemplate.update(updateReservesSql, userId, userId, userId);

            String updateNotificationsSql = "UPDATE notifications SET from_whom_user_id = NULL, to_whom_user_id = NULL, reserve_id = NULL, charity_id = NULL, wish_id = NULL WHERE from_whom_user_id = ? OR to_whom_user_id = ? OR reserve_id = ? OR charity_id = ? OR wish_id = ?";
            jdbcTemplate.update(updateNotificationsSql, userId, userId, userId, userId, userId);

            String updateWishesSql = "UPDATE wishes SET holiday_id=NULL WHERE holiday_id=?";
            jdbcTemplate.update(updateWishesSql, userId);

            String updateReserveSql = "UPDATE reserves SET charity_id = NULL, wish_id = NULL, user_id = NULL WHERE charity_id = ? OR wish_id = ? OR user_id = ?";
            jdbcTemplate.update(updateReserveSql, userId, userId, userId);

            String updateUserFriendSql = "UPDATE users_friends SET friends_id=NULL WHERE friends_id=?";
            jdbcTemplate.update(updateUserFriendSql, userId);

            String updateFriendsSql = "UPDATE users_friends SET friends_id = NULL WHERE friends_id = ?";
            jdbcTemplate.update(updateFriendsSql, userId);

            String updateWishComplaintSql = "UPDATE wishes_complaints SET wish_id=NULL ,complaints_id=NULL where wish_id=? OR complaints_id=?";
            jdbcTemplate.update(updateWishComplaintSql, userId, userId);

            String updateRequestForFriend = "UPDATE users_requests_for_friends SET requests_for_friends_id=NULL ,user_id=NULL WHERE requests_for_friends_id=? OR user_id=?";
            jdbcTemplate.update(updateRequestForFriend, userId,userId);

            String updateCharityComplaintSql="UPDATE charities_complaints SET charity_id=NULL ,complaints_id=NULL WHERE charity_id=? OR complaints_id=?";
            jdbcTemplate.update(updateCharityComplaintSql,userId,userId);


            String deleteCharitiesComplaintsSql = "DELETE FROM charities_complaints WHERE charity_id IN (SELECT charity_id FROM charities WHERE user_id = ?)";
            jdbcTemplate.update(deleteCharitiesComplaintsSql, userId);

            String deleteWishesComplaintsSql = "DELETE FROM wishes_complaints WHERE complaints_id IN (SELECT complaints_id FROM complaints WHERE user_id = ?)";
            jdbcTemplate.update(deleteWishesComplaintsSql, userId);

            String deleteReservesSql = "DELETE FROM reserves WHERE wish_id IN (SELECT wish_id FROM wishes WHERE user_id = ?)";
            jdbcTemplate.update(deleteReservesSql, userId);


            String deleteNotificationsSql = "DELETE FROM notifications WHERE from_whom_user_id = ? OR to_whom_user_id = ?";
            jdbcTemplate.update(deleteNotificationsSql, userId, userId);

            String deleteWishesSql = "DELETE FROM wishes WHERE user_id = ? OR holiday_id IN (SELECT id FROM holidays WHERE user_id = ?)";
            jdbcTemplate.update(deleteWishesSql, userId, userId);

            String deleteWishes1Sql = "DELETE FROM wishes WHERE user_id = ?";
            jdbcTemplate.update(deleteWishes1Sql, userId);

            String deleteCharitiesSql = "DELETE FROM charities WHERE user_id = ?";
            jdbcTemplate.update(deleteCharitiesSql, userId);

            String deleteComplaintsSql = "DELETE FROM complaints WHERE user_id = ?";
            jdbcTemplate.update(deleteComplaintsSql, userId);

            String deleteHolidaysSql = "DELETE FROM holidays WHERE user_id = ?";
            jdbcTemplate.update(deleteHolidaysSql, userId);

            String deleteFriendshipSql = "DELETE FROM users_friends WHERE user_id = ?";
            jdbcTemplate.update(deleteFriendshipSql, userId);

            String deleteUserSql = "DELETE FROM users WHERE id = ?";
            jdbcTemplate.update(deleteUserSql, userId);
            return SimpleResponse.builder()
                    .status(HttpStatus.OK)
                    .message(String.format("User with %s id successfully deleted", userId))
                    .build();
        } catch (DataAccessException ex) {
            throw new RuntimeException("Error deleting user with id " + userId, ex);
        }
    }
}
