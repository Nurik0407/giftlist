package com.example.giftlistb8.entities;

import com.example.giftlistb8.enums.Type;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "notifications")
@Data
@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_gen")
    @SequenceGenerator(name = "notification_id_gen",
            sequenceName = "notification_id_gen", allocationSize = 1, initialValue = 10)
    @Column(nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String message;
    private Boolean seen;
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User fromWhomUser;

    @ManyToOne
    @JoinColumn
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User toWhomUser;

    @OneToOne
    @JoinColumn
    private Wish wish;

    @OneToOne
    @JoinColumn
    private Charity charity;

    @OneToOne(cascade = {ALL},orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Reserve reserve;

}