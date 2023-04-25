package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendRepository  extends JpaRepository<User,Long> {
    @Query("SELECT new com.example.giftlistb8.dto.friend.response.FriendInfoResponse(" +
            "f.id, " +
            "f.userInfo.image, " +
            "CONCAT(f.firstName, ' ', f.lastName), " +
            "f.holidays.size, " +
            "f.wishes.size) " +

            "FROM User u JOIN u.friends f WHERE u.email = ?1")
    List<FriendInfoResponse> getAllFriends(String email);

    @Query("select new com.example.giftlistb8.dto.friend.response.FriendInfoResponse( " +
            "f.id," +
            "f.userInfo.image," +
            "concat(f.firstName,' ',f.lastName)," +
            "f.holidays.size" +
            ",f.wishes.size) from User u join u.requestsForFriends f where u.email =?1")
    List<FriendInfoResponse>getAllRequests(String email);

}
