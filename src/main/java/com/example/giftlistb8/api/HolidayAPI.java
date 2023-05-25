package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.holiday.request.HolidayRequest;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.services.HolidayService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Tag(name = "Holiday API", description = "API for managing holidays")
public class HolidayAPI {
    private final HolidayService service;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public List<HolidayResponse> findAllHolidays() {
        return service.findAll();
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping
    public SimpleResponse saveHoliday(@RequestBody @Valid HolidayRequest request) {
        return service.save(request);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping
    public SimpleResponse updateHoliday(@RequestParam Long holidayId, @RequestBody @Valid HolidayRequest request) {
        return service.update(holidayId, request);
    }

    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping
    public SimpleResponse deleteHoliday(@RequestParam Long holidayId) {
        return service.delete(holidayId);
    }
}
