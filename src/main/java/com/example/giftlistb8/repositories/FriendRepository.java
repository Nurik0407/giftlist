package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<User, Long> {

    @Query("SELECT NEW com.example.giftlistb8.dto.friend.response.FriendInfoResponse(" +
           "f.id, " +
           "ui.image, " +
           "CONCAT(f.firstName, ' ', f.lastName), " +
           " CAST(COUNT(w.id) AS int), " +
           "CAST(COUNT(c.id) AS int))" +
           "FROM User u JOIN u.friends f " +
           "LEFT JOIN f.userInfo ui " +
           "LEFT JOIN f.wishes w " +
           "LEFT JOIN f.charities c " +
           "WHERE u.id = ?1 " +
           "GROUP BY f.id, ui.image, f.firstName, f.lastName " +
           "ORDER BY f.id DESC")
    List<FriendInfoResponse> getAllFriends(Long id);
    @Query("SELECT NEW com.example.giftlistb8.dto.friend.response.FriendInfoResponse(" +
           "f.id, " +
           "ui.image, " +
           "CONCAT(f.firstName, ' ', f.lastName), " +
           "CAST(COUNT(w.id) AS int), " +
           "CAST(COUNT(c.id) AS int)) " +
           "FROM User u JOIN u.requestsForFriends f " +
           "LEFT JOIN f.userInfo ui " +
           "LEFT JOIN f.wishes w " +
           "LEFT JOIN f.charities c " +
           "WHERE u.id = ?1 " +
           "GROUP BY f.id, ui.image, f.firstName, f.lastName " +
           "ORDER BY f.id DESC")  List<FriendInfoResponse> getAllRequests(Long id);

}
