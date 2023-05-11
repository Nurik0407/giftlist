package com.example.giftlistb8.entities;

import com.example.giftlistb8.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen",
            sequenceName = "user_id_seq", allocationSize = 1, initialValue = 11)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Boolean isBlocked;
    private boolean subscribeMailing;
    @OneToOne(cascade = CascadeType.ALL)
    private UserInfo userInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Charity> charities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Complaint> complaints;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Wish> wishes;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reserve> reserves;

    @OneToMany(mappedBy = "fromWhomUser", cascade = CascadeType.ALL)
    private List<Notification> fromWhomUserNotifications;

    @OneToMany(mappedBy = "toWhomUser", cascade = CascadeType.ALL)
    private List<Notification> myNotifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Holiday> holidays;

    @OneToMany(cascade = {DETACH, REFRESH, MERGE, PERSIST})
    private List<User> requestsForFriends;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> friends;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void deleteHoliday(Holiday holiday) {
        holidays.remove(holiday);
    }

    public void deleteCharity(Charity charity) {
        charities.remove(charity);
    }
    public void deleteWish(Wish wish){
        wishes.remove(wish);
    }
}