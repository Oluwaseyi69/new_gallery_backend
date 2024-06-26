package com.imagesave.imagesave.service;

import com.imagesave.imagesave.data.models.Image;
import com.imagesave.imagesave.data.repository.ImageRepo;
import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.UploadRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageRepo imageRepo;

    @Override
    public ApiResponse<?> upload(UploadRequest request){
        log.info("Uploading image");
        Image image = createImage(request);
        log.info("Image created");
        imageRepo.save(image);
        log.info("Image saved");
        String content = image.getLink();
        log.info("Content of image: {}", content);
        writeToFile(content);
        log.info("Image saved");
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

    @Override
    public ApiResponse<?> getImagesFromFile(){
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("pictureUrls.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ApiResponse.success(lines, "all images found");
    }

    private Image createImage(UploadRequest request){
        Image image = new Image();
        image.setLink(request.getLink());
        image.setName(request.getName());
        return image;
    }

    public void writeToFile(String content) {
        try (FileWriter writer = new FileWriter("pictureUrls.txt", true)) {
            writer.write(content + System.lineSeparator());
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }


}
