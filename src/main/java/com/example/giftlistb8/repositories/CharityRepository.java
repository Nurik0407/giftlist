package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.entities.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharityRepository extends JpaRepository<Charity, Long> {
    @Query("SELECT NEW com.example.giftlistb8.dto.charity.response.CharityResponse(CONCAT(u.lastName, ',', u.firstName), ui.phoneNumber, c.name, c.description, c.category, c.subCategory, c.state, c.dateOfIssue, c.image, case when r.id = null then false else true end , COALESCE(r.isAnonymous, false)) " +
            "FROM Charity c " +
            "LEFT JOIN c.reserve r " +
            "JOIN c.user u " +
            "LEFT JOIN u.userInfo ui " +
            "WHERE c.id= ?1")
    CharityResponse findCharityById(Long id);
}