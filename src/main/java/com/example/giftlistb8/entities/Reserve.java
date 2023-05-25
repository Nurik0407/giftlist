package com.example.giftlistb8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "reserves")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserve_id_gen")
    @SequenceGenerator(name = "reserve_id_gen",
            sequenceName = "reserve_id_seq",allocationSize = 1,initialValue = 10)
    private Long id;
    private Boolean isAnonymous;

    @OneToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private Charity charity;

    @OneToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private Wish wish;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user;
}