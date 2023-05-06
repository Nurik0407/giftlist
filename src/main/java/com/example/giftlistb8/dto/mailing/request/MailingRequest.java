package com.example.giftlistb8.dto.mailing.request;

import lombok.Builder;
import lombok.Data;

@Data
public class MailingRequest {
    private String title;
    private String text;
    private String image;
}
