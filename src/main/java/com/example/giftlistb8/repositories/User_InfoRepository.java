package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_InfoRepository extends JpaRepository<UserInfo, Long> {
}