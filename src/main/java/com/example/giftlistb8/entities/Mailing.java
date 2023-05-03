package com.example.giftlistb8.entities;

import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "mailings")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Mailing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mailing_id_gen")
    @SequenceGenerator(name = "mailing_id_gen",
            sequenceName = "mailing_id_seq",allocationSize = 1,initialValue = 10)
    private Long id;
    private String title;
    private String description;
    private String image;
    private LocalDate createdAt;

}