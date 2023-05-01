package com.example.giftlistb8.entities;

import com.example.giftlistb8.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "notifications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_gen")
    @SequenceGenerator(name = "notification_id_gen",
            sequenceName = "notification_id_seq", allocationSize = 1, initialValue = 4)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String message;
    private Boolean seen;
    private LocalDate createdAt;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private User fromWhomUser;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private User toWhomUser;

    @OneToOne(cascade = {PERSIST, MERGE, DETACH, REFRESH})
    private Wish wish;

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE, DETACH})
    private Charity charity;

    @OneToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private Reserve reserve;
}