package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM charities_complaints WHERE complaints_id IN (SELECT c.id FROM complaints c WHERE user_id = ?1)")
    void deleteFromCharityComplaint(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM wishes_complaints WHERE complaints_id IN (SELECT c.id FROM complaints c WHERE user_id = ?1)")
    void deleteFromWishComplaint(Long userId);
}