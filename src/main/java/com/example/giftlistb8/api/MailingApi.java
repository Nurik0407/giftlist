package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import com.example.giftlistb8.dto.mailing.response.AllMailingResponse;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;
import com.example.giftlistb8.services.MailingServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/mailing_list")
@PreAuthorize("hasAuthority('ADMIN')")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MailingApi {

    private final MailingServices mailingService;

    @Autowired
    public MailingApi(MailingServices mailingService) {
        this.mailingService = mailingService;
    }


    @Operation(summary = "Mailing list and save",
            description = "mailing  sent and saved to database")
    @PostMapping
    public void sendEmail(@RequestBody MailingRequest request) throws MessagingException {
        mailingService.sendMailWithAttachment(request);
    }


    @Operation(summary = "All mailing list")
    @GetMapping
    public List<AllMailingResponse> getAllMailingList() {
        return mailingService.getAllMailingList();
    }


    @Operation(summary = "get by id  mailing list")
    @GetMapping("/{id}")
    public Optional<MailingResponse> getByIdMailingList(@PathVariable Long id) {
        return mailingService.getMailingById(id);
    }


    @Operation(summary = "Delete mailing list",
            description = "Admin can delete mailing list")
    @DeleteMapping("/{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        return mailingService.delete(id);
    }
}

