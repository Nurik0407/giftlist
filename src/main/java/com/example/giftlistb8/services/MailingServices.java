package com.example.giftlistb8.services;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import com.example.giftlistb8.dto.mailing.response.AllMailingResponse;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;
import jakarta.mail.MessagingException;

import java.util.List;

public interface MailingServices {

    SimpleResponse sendMailWithAttachment(MailingRequest request) throws MessagingException;

    List<AllMailingResponse> getAllMailingList();

    MailingResponse getByIdMailingList(Long id);

    SimpleResponse delete(Long id);
}
