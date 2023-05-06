package com.example.giftlistb8.api;


import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import com.example.giftlistb8.services.serviceImpl.MailingServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mailing_list")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('USER')")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MailingApi {

    @Autowired
    private final MailingServiceImpl mailingService;
    @Operation(summary = "Mailing list and save",
    description = "mailing  sent and saved to database")
    @PostMapping
    public void triggerMail(@RequestBody MailingRequest request) throws MessagingException {
        mailingService.sendMailWithAttachment(request);
    }
}
