package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.mailing.response.AllMailingResponse;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;
import com.example.giftlistb8.entities.Mailing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MailingRepository extends JpaRepository<Mailing, Long> {

}
