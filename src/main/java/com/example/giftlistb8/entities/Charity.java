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
@Table(name = "charities")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Charity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charity_id_gen")
    @SequenceGenerator(name = "charity_id_gen",
            sequenceName = "charity_id_seq")
    private Long id;
    private String name;
    private String state;
    private String category;
    private String subCategory;
    private String description;
    private LocalDate date;


    @ElementCollection
    private List<String> images;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    @OneToOne(mappedBy = "charity", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private Reserve reserve;
}