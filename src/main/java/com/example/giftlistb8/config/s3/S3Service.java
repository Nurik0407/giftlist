package com.example.giftlistb8.config.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.giftlistb8.dto.s3.response.S3Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
public class S3Service {


    private final AmazonS3 amazonS3;
    @Value("${aws_bucket_name}")
    private String bucketName;
    @Value("${aws_s3_link}")
    private String awsUrl;


    public S3Service(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }


    public S3Response uploadFile(String key, MultipartFile multipartFile) throws IOException {
        File file = convertMultiPartFileToFile(multipartFile);
        PutObjectRequest request = new PutObjectRequest(bucketName, key, file);
        amazonS3.putObject(request);
        return S3Response.builder()
                .status(HttpStatus.OK)
                .message("File successfully upload.")
                .url(awsUrl+key)
                .build();
    }


    public S3Response deleteFile(String fileLink) {
        String key = fileLink.substring(awsUrl.length());
        amazonS3.deleteObject(bucketName, key);
        return S3Response.builder()
                .status(HttpStatus.NO_CONTENT)
                .message("File with key %s successfully deleted.".formatted(key))
                .url(awsUrl+key)
                .build();
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            FileOutputStream fos = new FileOutputStream(convertedFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            log.error("Error converting multiPartFile to file.", e.getCause());
        }
        return convertedFile;
    }
}
