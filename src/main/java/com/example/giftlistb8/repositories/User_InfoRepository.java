package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.User_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_InfoRepository extends JpaRepository<User_Info, Long> {
}