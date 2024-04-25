package com.imagesave.imagesave.service;


import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.LoginRequest;

public interface UserService {

    ApiResponse<?> login(LoginRequest loginRequest);

    void createMainUser();
}
