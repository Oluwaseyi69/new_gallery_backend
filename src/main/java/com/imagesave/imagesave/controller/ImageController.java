package com.imagesave.imagesave.controller;

import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.UploadRequest;
import com.imagesave.imagesave.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ImageController {

    private ImageService imageService;

    @PostMapping("/upload")
    public ApiResponse<?> saveImage(UploadRequest uploadRequest) {
        try {
            return imageService.upload(uploadRequest);
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }

    @GetMapping("/images")
    public ApiResponse<?> getImages() {
        try {
            return imageService.getImages();
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }


    @GetMapping("/file/images")
    public ApiResponse<?> getImagesFromFile() {
        try {
            return imageService.getImagesFromFile();
        } catch (Exception e) {
            return ApiResponse.error(e.getMessage());
        }
    }




}
