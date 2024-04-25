package com.imagesave.imagesave.data.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("Images")
public class Image {

    private String id;
    private String name;
    private String link;
}
