package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.holiday.request.HolidayRequest;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.services.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
@RequiredArgsConstructor
public class HolidayAPI {
    private final HolidayService service;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public List<HolidayResponse> findAllHolidays() {
        return service.findAll();
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping
    public SimpleResponse saveHoliday(@RequestBody HolidayRequest request) {
        return service.save(request);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping
    public SimpleResponse updateHoliday(@RequestParam Long holidayId, @RequestBody HolidayRequest request) {
        return service.update(holidayId, request);
    }

    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping
    public SimpleResponse deleteHoliday(@RequestParam Long holidayId) {
        return service.delete(holidayId);
    }
}
