package com.example.giftlistb8.dto.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WhoComplaintResponse{
        private Long userId;
        private String fullName;
        private String userImage;
        private String causesOfComplaint;

}
