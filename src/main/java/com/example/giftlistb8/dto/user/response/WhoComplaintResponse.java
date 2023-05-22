package com.example.giftlistb8.dto.user.response;

<<<<<<< HEAD
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WhoComplaintResponse{
        private Long userId;
        private String fullName;
        private String userImage;
        private String causesOfComplaint;
=======
=======
import lombok.AllArgsConstructor;
>>>>>>> 390fdea (add some methods to complaint)
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
<<<<<<< HEAD
public record WhoComplaintResponse(
        Long userId,
        String fullName,
        String userImage,
        String causesOfComplaint
) {
>>>>>>> 8e60948 (added CharityResponseProfile)
=======
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WhoComplaintResponse{
        private Long userId;
        private String fullName;
        private String userImage;
        private String causesOfComplaint;
>>>>>>> 390fdea (add some methods to complaint)
}
