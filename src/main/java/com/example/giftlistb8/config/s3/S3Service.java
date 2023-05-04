package com.example.giftlistb8.config.s3;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.example.giftlistb8.dto.s3.response.S3Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
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
        amazonS3.putObject(bucketName, key, file);
        file.delete();
        String fileUrl = getPresignedUrl(bucketName, key);
        return S3Response.builder()
                .status(HttpStatus.OK)
                .message("File successfully upload.")
                .url(fileUrl)
                .build();
    }


    public S3Response deleteFile(String key) {
        amazonS3.deleteObject(bucketName, key);
        String fileUrl = awsUrl + getPresignedUrl(bucketName, key);
        return S3Response.builder()
                .status(HttpStatus.NO_CONTENT)
                .message("File with key [%s] successfully deleted.".formatted(key))
                .url(fileUrl)
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

    public String getPresignedUrl(String bucketName, String objectKey) {
        Date expiration = new Date(System.currentTimeMillis() + 3600000); // 1 hour from now
        GeneratePresignedUrlRequest generatePresignedUrlRequest =
                new GeneratePresignedUrlRequest(bucketName, objectKey)
                        .withMethod(HttpMethod.GET)
                        .withExpiration(expiration);
        URL url = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }
}
