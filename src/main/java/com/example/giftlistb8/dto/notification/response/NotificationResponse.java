package com.example.giftlistb8.dto.notification.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class NotificationResponse{

  private Long notificationId;
   private Long fromWhomUserId;
   private String fromWhomUserFullName;
   private String wishName;
   private Long wishId;
   private String charityName;
   private Long charityId;
   private String image;
   private String type;
   private String message;
   private boolean seen;
   private LocalDate createdAt;
}
