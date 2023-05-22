package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}