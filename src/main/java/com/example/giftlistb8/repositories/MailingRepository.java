package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.mailing.response.AllMailingResponse;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;
import com.example.giftlistb8.entities.Mailing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MailingRepository extends JpaRepository<Mailing, Long> {
    @Query("SELECT NEW com.example.giftlistb8.dto.mailing.response.MailingResponse(" +
            "m.id ," +
            "m.image ," +
            "m.title ," +
            "m.description ," +
            "m.createdAt) FROM Mailing m where m.id=:id")
    Optional<MailingResponse> getMailingById(Long id);

    @Query("SELECT NEW com.example.giftlistb8.dto.mailing.response.AllMailingResponse(" +
            "m.id," +
            "m.image," +
            "m.title," +
            "m.createdAt) from Mailing m ")
    List<AllMailingResponse> getAllMailingList();
}
