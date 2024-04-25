package com.imagesave.imagesave.data.repository;

import com.imagesave.imagesave.data.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepo extends MongoRepository<Image, String> {
}
