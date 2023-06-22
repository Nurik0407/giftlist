package com.example.giftlistb8.api;

import com.example.giftlistb8.dto.SimpleResponse;
import com.example.giftlistb8.dto.wish.requests.WishRequest;
import com.example.giftlistb8.dto.wish.response.GlobalSearchWish;
import com.example.giftlistb8.dto.wish.responses.WishResponse;
import com.example.giftlistb8.services.WishService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/wishes")
@CrossOrigin(origins = "*")
@Tag(name = "Wish API", description = "API for managing wishes")
public class WishAPI {

    private final WishService service;

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public List<WishResponse> findAllWishes(){
    return service.findAll();
}

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/{id}")
    public WishResponse getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping
    public SimpleResponse save(@RequestBody WishRequest request){
        return service.save(request);
    }

    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping
    public SimpleResponse delete(@RequestParam Long id){
        return service.delete(id);
    }

    @PreAuthorize("hasAuthority('USER')")
    @PutMapping
    public SimpleResponse update(@RequestParam Long id,@RequestBody WishRequest request){
        return service.update(id, request);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @Operation(summary = "The method for searching wish",description = "Global search of wish")
    @GetMapping("/search")
    public List<GlobalSearchWish>globalSearches(@RequestParam(required = false) String keyWord){
        return service.search(keyWord);
    }
}