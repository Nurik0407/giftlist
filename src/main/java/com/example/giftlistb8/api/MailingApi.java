package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.mailing.request.MailingRequest;
import com.example.giftlistb8.dto.mailing.response.AllMailingResponse;
import com.example.giftlistb8.dto.mailing.response.MailingResponse;
import com.example.giftlistb8.services.MailingServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mailing_list")
@PreAuthorize("hasAuthority('ADMIN')")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Mailing API", description = "API for managing mailings by admin")
public class MailingApi {

    private final MailingServices mailingService;

    @Operation(summary = "Mailing list and save",
            description = "mailing  sent and saved to database")
    @PostMapping
    public SimpleResponse sendEmail(@RequestBody MailingRequest request) throws MessagingException {
        return mailingService.sendMailWithAttachment(request);
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

