package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.charity.request.CharityRequest;
import com.example.giftlistb8.dto.charity.request.CharityUpdateRequest;
import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.dto.charity.response.CharityResponse;
import com.example.giftlistb8.dto.charity.response.GlobalSearchCharity;
import com.example.giftlistb8.services.CharityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/charities")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Charity API",description = "API for managing charity organizations")
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
    public SimpleResponse save(@RequestBody @Valid CharityRequest request) {
        return service.save(request);
    }

    @PutMapping
    public SimpleResponse update(@RequestBody @Valid CharityUpdateRequest request) {
        return service.update(request);
    }

    @DeleteMapping
    public SimpleResponse delete(@RequestParam Long id) {
        return service.delete(id);
    }
    @Operation(summary = "The method for searching charities information",description = "Global search for charity")
    @GetMapping("/search")
    public List<GlobalSearchCharity>globalSearches(@RequestParam(required = false) String keyWord){
        return service.globalSearch(keyWord);
    }
}
