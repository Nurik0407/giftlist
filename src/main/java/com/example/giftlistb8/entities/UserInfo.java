package com.example.giftlistb8.entities;

import com.example.giftlistb8.enums.ClothingSize;
import com.example.giftlistb8.enums.ShoeSize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user_infos")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_id_gen")
    @SequenceGenerator(name = "user_info_id_gen",
            sequenceName = "user_info_id_seq",allocationSize = 1,initialValue = 10)
    private Long id;
    private String phoneNumber;
    private String image;
    private LocalDate dateOfBirth;
    private String country;
    private String hobby;
    private String important;
    private ClothingSize clothingSize;
    private ShoeSize shoeSize;
    private String instagram;
    private String telegram;
    private String facebook;
    private String whatsApp;

    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL)
    private User user;
}