package com.example.giftlistb8.repositories;

import com.example.giftlistb8.dto.friend.response.FriendInfoResponse;
import com.example.giftlistb8.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<User, Long> {
    @Query("SELECT new com.example.giftlistb8.dto.friend.response.FriendInfoResponse(" +
            "f.id, " +
            "f.userInfo.image, " +
            "CONCAT(f.firstName, ' ', f.lastName), " +
            "cast(size(f.holidays) as int) , " +
            "cast(size(f.wishes) as int)) from User u join u.friends f WHERE u.email = ?1")
    List<FriendInfoResponse> getAllFriends(String email);

    @Query("select new com.example.giftlistb8.dto.friend.response.FriendInfoResponse( " +
            "f.id, " +
            "f.userInfo.image, " +
            "concat(f.firstName,' ',f.lastName), " +
            "cast(size(f.holidays) as int) , " +
            "cast(size(f.wishes) as int)) from User u join u.requestsForFriends f where u.email =?1")
    List<FriendInfoResponse> getAllRequests(String email);

}
