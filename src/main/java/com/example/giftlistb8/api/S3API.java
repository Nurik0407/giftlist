package com.example.giftlistb8.api;

import com.example.giftlistb8.config.s3.S3Service;
import com.example.giftlistb8.dto.s3.response.S3Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
public class S3API {


    private final S3Service s3Service;


    @PostMapping("/upload")
    public S3Response uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            return s3Service.uploadFile(file.getOriginalFilename(), file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{key}")
    public S3Response deleteFile(@PathVariable String key) {
        return s3Service.deleteFile(key);
    }
}