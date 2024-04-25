package com.imagesave.imagesave.data.models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class User {

    private String id;
    private String username;
    private String password;

}
