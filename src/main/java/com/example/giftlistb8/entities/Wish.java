package com.example.giftlistb8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "wishes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wish_seq")
    @SequenceGenerator(name = "wish_seq",allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @Column(name = "link_gift")
    private String linkGift;
    private String image;
    private String description;
    @Column(name = "date_of_holiday")
    private LocalDate dateOfHoliday;
    private Boolean status;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn()
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn()
    private List<Complaint> complaints;

    @OneToOne(mappedBy = "wish", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Reserve reserve;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn()
    private Holiday holiday;

    public Wish(String name, String linkGift, String image, String description, LocalDate dateOfHoliday, Boolean status) {
        this.name = name;
        this.linkGift = linkGift;
        this.image = image;
        this.description = description;
        this.dateOfHoliday = dateOfHoliday;
        this.status = status;
    }

}