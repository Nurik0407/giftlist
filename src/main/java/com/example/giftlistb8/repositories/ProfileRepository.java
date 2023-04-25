package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProfileRepository extends JpaRepository<UserInfo, Long> {
}
