package com.example.giftlistb8.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "charities")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Charity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charity_seq")
    @SequenceGenerator(name = "charity_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String state;
    private String category;
    @Column(name = "sub_category")
    private String subCategory;
    private String description;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn()
    private User user;

    @ElementCollection
    private List<String> images;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn()
    private List<Complaint> complaints;

    @OneToOne(mappedBy = "charity", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    private Reserve reserve;

    public Charity(String name, String state, String category, String subCategory, String description) {
        this.name = name;
        this.state = state;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
    }
}