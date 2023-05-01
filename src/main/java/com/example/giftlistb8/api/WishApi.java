package com.example.giftlistb8.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wish")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class WishApi {
}
