package com.example.giftlistb8.entities;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mailing_seq")
    @SequenceGenerator(name = "mailing_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private String image;
    @Column(name = "created_at")
    private LocalDate createdAt;


}