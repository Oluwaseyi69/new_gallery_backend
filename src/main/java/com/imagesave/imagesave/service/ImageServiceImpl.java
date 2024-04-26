package com.imagesave.imagesave.service;

import com.imagesave.imagesave.data.models.Image;
import com.imagesave.imagesave.data.repository.ImageRepo;
import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.UploadRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImageServiceImpl implements ImageService{

    private ImageRepo imageRepo;

    @Override
    public ApiResponse<?> upload(UploadRequest request){
        Image image = createImage(request);
        imageRepo.save(image);
        return ApiResponse.success(null, "Image uploaded successfully");
    }

    @Override
    public ApiResponse<?> getImages() {
        List<Image> images = imageRepo.findAll();
        if(images == null){
            throw new IllegalArgumentException("No images found");
        }
        return ApiResponse.success(images, "Image found");
    }

    private Image createImage(UploadRequest request){
        Image image = new Image();
        image.setLink(request.getLink());
        image.setName(request.getName());
        return image;
    }


}
