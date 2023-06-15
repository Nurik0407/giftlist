package com.example.giftlistb8.repositories;


import com.example.giftlistb8.dto.profile.response.ProfileResponse;
import com.example.giftlistb8.dto.profile.response.ProfileResponseGetById;
import com.example.giftlistb8.dto.user.response.GlobalSearchFriend;
import com.example.giftlistb8.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query("select new com.example.giftlistb8.dto.profile.response.ProfileResponseGetById(u.id,ui.image,concat(u.firstName,' ',u.lastName),u.email) from User u join u.userInfo ui where u.id=:userId")
    Optional<ProfileResponseGetById> getByIdUser(Long userId);

    @Query("select new com.example.giftlistb8.dto.profile.response.ProfileResponse(u.id,ui.image,u.lastName,u.firstName,ui.country,u.email,ui.hobby,ui.dateOfBirth,ui.phoneNumber,ui.important," +
            "ui.clothingSize,ui.shoeSize,ui.facebook ,ui.instagram,ui.telegram,ui.whatsApp) from User u join u.userInfo ui where u.id=:userId")
    Optional<ProfileResponse> getByIdUserDetail(Long userId);

    Optional<User> getUserById(Long userId);

    @Query("SELECT COUNT(u.id) > 0 FROM User u " +
           "JOIN u.friends f where u.id = ?1 and f.id = ?2")
    boolean inMyFriends(Long currentUserId,Long userId);
    @Query("SELECT count (u.id) > 0 FROM User u " +
           "JOIN u.requestsForFriends r where u.id = ?1 and r.id = ?2")
    boolean inMyRequests(Long currentUser,Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM users u WHERE u.id = ?1")
    void deleteUser(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM reserves r WHERE r.user_id = ?1")
    void deleteFromReserve(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM users_requests_for_friends  WHERE requests_for_friends_id = ?1")
    void deleteFromUsersRequestsForFriends(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM notifications WHERE from_whom_user_id = ?1 OR to_whom_user_id = ?1")
    void deleteFromNotifications(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM users_friends WHERE user_id = ?1 OR friends_id = ?1")
    void deleteFromFriends(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM wishes WHERE user_id = ?1")
    void deleteFromWish(Long userId);

    @Modifying
    @Query(nativeQuery = true,value = "DELETE FROM holidays WHERE user_id = ?1")
    void deleteFromHoliday(Long userId);

    @Query("SELECT NEW com.example.giftlistb8.dto.user.response.GlobalSearchFriend(u.id, CONCAT(u.firstName, ' ', u.lastName), ui.image, u.userInfo.phoneNumber, u.userInfo.dateOfBirth, u.userInfo.country, w.name, h.name, c.name, u.userInfo.hobby) " +
            "FROM User u " +
            "JOIN u.userInfo ui " +
            "LEFT JOIN u.wishes w " +
            "LEFT JOIN w.holiday h " +
            "LEFT JOIN u.charities c " +
            "WHERE LOWER(u.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.userInfo.phoneNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.userInfo.country) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(w.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(h.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.userInfo.hobby) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<GlobalSearchFriend> globalSearch(@Param("keyword") String keyword);
}