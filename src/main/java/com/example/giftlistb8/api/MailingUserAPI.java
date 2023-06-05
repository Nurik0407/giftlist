package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.repositories.MailingRepository;
import com.example.giftlistb8.repositories.UserRepository;
import com.example.giftlistb8.services.MailingServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mailing")
@PreAuthorize("hasAuthority('USER')")
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Mailing User API", description = "API for managing mailings by user")
public class MailingUserAPI {

    private final MailingServices mailingServices;

    @PutMapping
    @Operation(description = "Subscribe to mailing.")
    public SimpleResponse subscribeToMailing(@RequestParam String email){
        return mailingServices.subscribeToMailing(email);
    }
}
