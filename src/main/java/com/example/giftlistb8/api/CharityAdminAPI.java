package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.charity.response.CharitiesResponse;
import com.example.giftlistb8.services.CharityAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/charity-admin")
public class CharityAdminAPI {
    private final CharityAdminService service;

    @GetMapping
    public List<CharitiesResponse> findALl(){
        return service.findAll();
    }

}
