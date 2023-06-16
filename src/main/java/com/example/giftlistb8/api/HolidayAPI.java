package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.holiday.request.HolidayRequest;
import com.example.giftlistb8.dto.holiday.response.GlobalSearchHoliday;
import com.example.giftlistb8.dto.holiday.response.HolidayByIdResponse;
import com.example.giftlistb8.dto.holiday.response.HolidayResponse;
import com.example.giftlistb8.services.HolidayService;
import io.swagger.v3.oas.annotations.Operation;
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
@PreAuthorize("hasAuthority('USER')")
public class HolidayAPI {
    private final HolidayService service;

    @GetMapping
    @Operation(summary = "Get all holidays", description = "Get a list of all holidays")
    public List<HolidayResponse> findAllHolidays() {
        return service.findAll();
    }

    @GetMapping("/details")
    @Operation(summary = "Get holiday by ID", description = "Get details of a holiday by its ID")
    public HolidayByIdResponse getById(@RequestParam Long id){
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Save a new holiday", description = "Save a new holiday")
    public SimpleResponse saveHoliday(@RequestBody @Valid HolidayRequest request) {
        return service.save(request);
    }

    @PutMapping
    @Operation(summary = "Update a holiday", description = "Update an existing holiday by its ID")
    public SimpleResponse updateHoliday(@RequestParam Long holidayId, @RequestBody @Valid HolidayRequest request) {
        return service.update(holidayId, request);
    }

    @DeleteMapping
    @Operation(summary = "Delete a holiday", description = "Delete a holiday by its ID")
    public SimpleResponse deleteHoliday(@RequestParam Long holidayId) {
        return service.delete(holidayId);
    }
    @Operation(summary = "The method for searching holiday",description = "Global search of holiday")
    @GetMapping("/search")
    public List<GlobalSearchHoliday>globalSearch(@RequestParam(required = false) String keyWord){
        return service.globalSearch(keyWord);
    }}
















