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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_seq")
    @SequenceGenerator(name = "notification_seq",allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private Type type;
    private String message;
    private Boolean seen;
    @Column(name = "created_at")
    private LocalDate createdAt;

    @ManyToOne(cascade = {PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn()
    private User fromWhomUser;

    @OneToOne(cascade = {PERSIST,MERGE,DETACH,REFRESH},orphanRemoval = true)
    @JoinColumn(name = "wish_id")
    private Wish wish;

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE, DETACH}, orphanRemoval = true)
    @JoinColumn(name = "charity_id")
    private Charity charity;

    @OneToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH}, orphanRemoval = true)
    @JoinColumn(name = "reserve_id")
    private Reserve reserve;

    public Notification(Type type, String message, Boolean seen, LocalDate createdAt) {
        this.type = type;
        this.message = message;
        this.seen = seen;
        this.createdAt = createdAt;
    }
}