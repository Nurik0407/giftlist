package com.example.giftlistb8.repositories;

import com.example.giftlistb8.entities.Mailing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailingRepository extends JpaRepository<Mailing, Long> {
}