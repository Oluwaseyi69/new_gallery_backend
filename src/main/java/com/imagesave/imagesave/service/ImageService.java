package com.imagesave.imagesave.service;

import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.UploadRequest;

public interface ImageService {
    ApiResponse<?> upload(UploadRequest request);

    ApiResponse<?> getImages();
}
