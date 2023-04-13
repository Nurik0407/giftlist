package com.example.giftlistb8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "holidays")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_id_gen")
    @SequenceGenerator(name = "holiday_id_gen",
            sequenceName = "holiday_id_seq")
    private Long id;
    private String name;
    private LocalDate date;
    private String image;
    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinColumn
    private User user;
    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL)
    private List<Wish> wishes;
}