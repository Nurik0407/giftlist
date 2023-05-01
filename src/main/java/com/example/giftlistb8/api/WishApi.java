package com.example.giftlistb8.api;

import com.example.giftlistb8.config.SimpleResponse;
import com.example.giftlistb8.dto.wish.requests.WishRequest;
import com.example.giftlistb8.dto.wish.responses.WishResponse;
import com.example.giftlistb8.services.WishService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/wishes")
public class WishAPI {
    private final WishService service;

//    @PreAuthorize("hasAuthority('USER')")
    @GetMapping
    public List<WishResponse> findAllWishes(){
        return service.findAll();
    }

//    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/{id}")
    public WishResponse getById(@PathVariable Long id){
        return service.getById(id);
    }

//    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/save")
    public SimpleResponse save(@RequestBody WishRequest request){
        System.out.println("hello");
        return service.save(request);
    }

//    @PreAuthorize("hasAuthority('USER')")
    @DeleteMapping("/{id}/delete")
    public SimpleResponse delete(@PathVariable Long id){
        return service.delete(id);
    }

//    @PreAuthorize("hasAuthority('USER')")
    @PutMapping("/{id}/update")
    public SimpleResponse update(@PathVariable Long id,@RequestBody WishRequest request){
        return service.update(id, request);
    }

}
