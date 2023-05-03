package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;

import java.util.List;

public interface MailingServices {
    List<MailingResponse> getAllMailingList();
    SimpleResponse saveMailing(MailingRequest request);
    SimpleResponse deleteMailing(Long id);
}
