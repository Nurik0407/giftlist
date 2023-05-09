package com.example.giftlistb8.api;

import com.example.giftlistb8.config.s3.S3Service;
import com.example.giftlistb8.dto.s3.response.S3Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/file")
@CrossOrigin(origins = "*")
@Tag(name = "S3", description = "API for working with files in Amazon S3 storage")
public class S3API {

    private final S3Service s3Service;

    @Operation(summary = "Upload a file to S3 bucket",
            description = "Uploads a file to the specified S3 bucket.")
    @PostMapping(consumes = { "multipart/form-data"})
    public S3Response uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            return s3Service.uploadFile(file.getOriginalFilename(), file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Operation(summary = "Delete a file from S3 bucket",
            description = "Deletes a file from the specified S3 bucket.")
    @DeleteMapping
    public S3Response deleteFile(@RequestParam("fileLink") String fileLink) {
        return s3Service.deleteFile(fileLink);
    }
}