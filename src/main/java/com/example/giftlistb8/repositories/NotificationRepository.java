package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NotificationRepository extends JpaRepository<Notification, Long> {


    @Modifying
    @Query(nativeQuery = true,value = "delete from notifications n where n.reserve_id = ?")
    void deleteNotification(Long reserveId);


    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM notifications WHERE type = 'COMPLAINT' and wish_id = ?1")
    void deleteFromWish(Long id);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM notifications WHERE type = 'COMPLAINT' and charity_id = ?1")
    void deleteFromCharity(Long id);
}