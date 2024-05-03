package com.imagesave.imagesave.controller;

import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.UploadRequest;
import com.imagesave.imagesave.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class ImageController {

    private ImageService imageService;

    @PostMapping("/upload")
    public ApiResponse<?> saveImage(@RequestBody UploadRequest uploadRequest) {
        log.info("Upload request: {}", uploadRequest);
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
