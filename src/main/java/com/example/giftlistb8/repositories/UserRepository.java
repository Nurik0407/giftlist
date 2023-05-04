package com.example.giftlistb8.repositories;


import com.example.giftlistb8.dto.profile.response.ProfileResponse;
import com.example.giftlistb8.dto.profile.response.ProfileResponseGetById;
import com.example.giftlistb8.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("select new com.example.giftlistb8.dto.profile.response.ProfileResponseGetById(u.id,ui.image,concat(u.firstName,' ',u.lastName),u.email) from User u join u.userInfo ui where u.id=:userId")
    Optional<ProfileResponseGetById> getByIdUser(Long userId);

    @Query("select new com.example.giftlistb8.dto.profile.response.ProfileResponse(u.id,ui.image,concat(u.firstName,' ',u.lastName),ui.country,u.email,ui.hobby,ui.dateOfBirth,ui.phoneNumber,ui.important," +
            "ui.clothingSize,ui.shoeSize,ui.facebook ,ui.instagram,ui.telegram,ui.whatsApp) from User u join u.userInfo ui where u.id=:userId")
    Optional<ProfileResponse> getByIdUserDetail(Long userId);

    Optional<User> getUserById(Long userId);
}