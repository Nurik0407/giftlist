package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.request.CharityRequest;
import com.example.giftlistb8.dto.charity.request.CharityUpdateRequest;
import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.services.CharityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charities")
@RequiredArgsConstructor
public class CharityAPI {

    private final CharityService service;

    @GetMapping
    public List<CharitiesResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/profile")
    public CharityResponse profile(@RequestParam Long id) {
        return service.findById(id);
    }

    @PostMapping
    public SimpleResponse save(@Valid CharityRequest request) {
        return service.save(request);
    }

    @PutMapping
    public SimpleResponse update(@Valid CharityUpdateRequest request) {
        return service.update(request);
    }

    @DeleteMapping
    public SimpleResponse delete(@RequestParam Long id) {
        return service.delete(id);
    }
}
