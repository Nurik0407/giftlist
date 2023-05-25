package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.request.CharityRequest;
import com.example.giftlistb8.dto.charity.request.CharityUpdateRequest;
import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.services.CharityAdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/charity-admin")
@Tag(name = "Admin Charity API", description = "API for managing charity organizations by admin")
@CrossOrigin(origins = "*")
public class CharityAdminAPI {
    private final CharityAdminService service;
    @GetMapping
    public List<CharitiesResponse> findAll() {
        return service.findAll();
    }

    @PostMapping
    public SimpleResponse save(@RequestBody @Valid CharityRequest request) {
        return service.save(request);
    }

    @PutMapping
    public SimpleResponse update(@RequestBody @Valid CharityUpdateRequest request) {
        return service.update(request);
    }

    @GetMapping("/profile")
    public CharityResponse profile(@RequestParam Long id) {
        return service.findById(id);
    }

    @DeleteMapping
    public SimpleResponse delete(@RequestParam Long id) {
        return service.delete(id);
    }

}
