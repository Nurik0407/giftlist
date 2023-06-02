package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Notification findByWishId(Long id);

    Notification findByCharityId(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "delete from notifications n where n.reserve_id = ?")
    void deleteNotification(Long reserveId);
}