package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.entities.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharityRepository extends JpaRepository<Charity, Long> {
    @Query("SELECT NEW com.example.giftlistb8.dto.charity.response.CharitiesResponse(CONCAT(u.lastName,',',u.firstName),c.name,c.image, c.dateOfIssue,(COUNT(r) > 0),COALESCE(r.isAnonymous,false)) FROM Charity c JOIN c.user u LEFT JOIN c.reserve r")
    List<CharitiesResponse> findAllCharity();

    @Query("SELECT NEW com.example.giftlistb8.dto.charity.response.CharityResponse(CONCAT(u.lastName, ',', u.firstName),ui.phoneNumber,c.name,c.description,c.category,c.subCategory,c.state,c.dateOfIssue,c.image,(COUNT(r) > 0),COALESCE(r.isAnonymous,false)) FROM Charity c JOIN c.user u JOIN u.userInfo ui LEFT JOIN c.reserve r WHERE c.id=:id")
    CharityResponse findCharityById(Long id);
}