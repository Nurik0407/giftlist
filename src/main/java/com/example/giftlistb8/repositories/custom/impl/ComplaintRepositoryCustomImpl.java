package com.example.giftlistb8.repositories.custom.impl;

import com.example.giftlistb8.dto.charity.response.CharityResponseWIthComplaint;
import com.example.giftlistb8.dto.complaint.response.ComplaintResponse;
import com.example.giftlistb8.dto.wish.response.WishResponseWithComplaint;
import com.example.giftlistb8.repositories.custom.ComplaintRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ComplaintRepositoryCustomImpl implements ComplaintRepositoryCustom {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public ComplaintResponse getAllComplaints() {

        String sql = """
                SELECT CONCAT(u.first_name, ' ', u.last_name) AS full_name, 
                ui.image AS user_image,
                ch.name AS charity_name,
                ch.date_of_issue AS charity_date_of_issue, 
                ch.image AS charity_image,
                c.complaint AS complaint_text,
                ui2.image AS complaint_user_image
                FROM charities ch
                         JOIN users u ON ch.user_id = u.id
                         JOIN user_infos ui ON u.user_info_id = ui.id
                         JOIN complaints c ON u.id = c.user_id
                         JOIN users u2 ON c.user_id = u2.id
                         JOIN user_infos ui2 ON u2.user_info_id = ui2.id;
                """;
        String sql2 = """
                SELECT CONCAT(u.first_name, ' ', u.last_name) AS full_name,
                ui.image AS user_image,
                w.name AS wish_name,
                w.date_of_holiday AS wish_holiday_date,
                w.image AS wish_image,
                c.complaint AS complaint_text,
                ui2.image AS complaint_user_image
                FROM wishes w
                         JOIN users u ON w.user_id = u.id
                         JOIN user_infos ui ON u.user_info_id = ui.id
                         JOIN complaints c ON u.id = c.user_id
                         JOIN users u2 ON c.user_id = u2.id
                         JOIN user_infos ui2 ON u2.user_info_id = ui2.id
                """;
        ComplaintResponse complaintResponse = new ComplaintResponse();

        List<CharityResponseWIthComplaint> charityResponses = jdbcTemplate.query(sql, (resultSet, i) ->
                new CharityResponseWIthComplaint(
                        resultSet.getString("full_name"),
                        resultSet.getString("user_image"),
                        resultSet.getString("charity_name"),
                        resultSet.getDate("charity_date_of_issue"),
                        resultSet.getString("charity_image"),
                        resultSet.getString("complaint_text"),
                        resultSet.getString("complaint_user_image")
                ));

        complaintResponse.setCharityResponseWIthComplaints(charityResponses);
        List<WishResponseWithComplaint> wishResponses = jdbcTemplate.query(sql2, (resultSet, i) ->
                new WishResponseWithComplaint(
                        resultSet.getString("full_name"),
                        resultSet.getString("user_image"),
                        resultSet.getString("wish_name"),
                        resultSet.getDate("wish_holiday_date"),
                        resultSet.getString("wish_image"),
                        resultSet.getString("complaint_text"),
                        resultSet.getString("complaint_user_image")
                ));
        complaintResponse.setWishResponseWithComplaints(wishResponses);

        return complaintResponse;
    }
}
