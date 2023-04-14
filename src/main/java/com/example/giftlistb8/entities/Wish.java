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
@Table(name = "wishes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wish_id_gen")
    @SequenceGenerator(name = "wish_id_gen",
            sequenceName = "wish_id_seq",allocationSize = 1,initialValue = 10)
    private Long id;
    private String name;
    private String linkGift;
    private String image;
    private String description;
    private LocalDate dateOfHoliday;
    private Boolean status;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    @OneToOne(mappedBy = "wish", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private Reserve reserve;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private Holiday holiday;
}