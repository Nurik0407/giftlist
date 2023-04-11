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
public class User_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_seq")
    @SequenceGenerator(name = "user_info_seq",allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String image;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String country;
    private String hobby;
    private String important;
    @Column(name = "clothing_size")
    private ClothingSize clothingSize;
    @Column(name = "shoe_size")
    private ShoeSize shoeSize;
    private String instagram;
    private String telegram;
    private String facebook;
    private String whatsApp;

    @OneToOne(mappedBy = "userInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    public User_Info(String phoneNumber, String image, LocalDate dateOfBirth, String country, String hobby, String important, ClothingSize clothingSize, ShoeSize shoeSize, String instagram, String telegram, String facebook, String whatsApp) {
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.hobby = hobby;
        this.important = important;
        this.clothingSize = clothingSize;
        this.shoeSize = shoeSize;
        this.instagram = instagram;
        this.telegram = telegram;
        this.facebook = facebook;
        this.whatsApp = whatsApp;
    }
}