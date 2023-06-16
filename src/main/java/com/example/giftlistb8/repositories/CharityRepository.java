package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.dto.charity.response.GlobalSearchCharity;
import com.example.giftlistb8.entities.Charity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface CharityRepository extends JpaRepository<Charity, Long> {
    @Query("SELECT NEW com.example.giftlistb8.dto.charity.response.CharityResponse(c.id,CONCAT(u.lastName, ',', u.firstName), ui.phoneNumber, c.name, c.description, c.category, c.subCategory, c.state, c.dateOfIssue, c.image, case when r.id is null then false else true end , COALESCE(r.isAnonymous, false),COALESCE(rui.image,null)) " +
           "FROM Charity c " +
           "LEFT JOIN c.reserve r " +
           "LEFT JOIN r.user ru " +
           "LEFT JOIN ru.userInfo rui " +
           "JOIN c.user u " +
           "LEFT JOIN u.userInfo ui " +
           "WHERE c.id= ?1")
    Optional<CharityResponse> findCharityById(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM charities WHERE id = ?1")
    void deleteCharity(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM reserves WHERE charity_id = ?1")
    void deleteFromReserve(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM notifications WHERE charity_id = ?1")
    void deleteFromNotifications(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM charities_complaints WHERE charity_id = ?1")
    void deleteFromCharityComplaints(Long id);

    @Query("SELECT NEW com.example.giftlistb8.dto.charity.response.GlobalSearchCharity(c.id,u.firstName, u.lastName, c.name, ui.phoneNumber, ui.image, c.dateOfIssue, ui.country, c.state, c.category, c.subCategory, CASE WHEN r.charity.id IS NULL THEN FALSE ELSE TRUE END) " +
            "FROM User u " +
            "JOIN u.userInfo ui " +
            "LEFT JOIN u.charities c " +
            "LEFT JOIN u.reserves r " +
            "WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(ui.phoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(ui.country) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.category) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.subCategory) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.state) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<GlobalSearchCharity> globalSearch(@Param("keyword") String keyword);
}