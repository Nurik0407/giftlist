package com.example.giftlistb8.entities;

import com.example.giftlistb8.enums.ClothingSize;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_infos")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_id_gen")
    @SequenceGenerator(name = "user_info_id_gen",
            sequenceName = "user_info_id_seq", allocationSize = 1, initialValue = 11)
    private Long id;
    private String phoneNumber;
    private String image;
    private LocalDate dateOfBirth;
    private String country;
    private String hobby;
    private String important;
    @Enumerated(EnumType.STRING)
    private ClothingSize clothingSize;
    private String shoeSize;
    private String instagram;
    private String telegram;
    private String facebook;
    private String whatsApp;
    private String resetToken;

    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL)
    private User user;
}