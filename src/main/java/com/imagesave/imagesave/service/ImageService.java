package com.imagesave.imagesave.service;

import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.UploadRequest;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    ApiResponse<?> upload(UploadRequest request);

    ApiResponse<?> getImages();
    void writeToFile(String content);
    ApiResponse<?> getImagesFromFile();
}
