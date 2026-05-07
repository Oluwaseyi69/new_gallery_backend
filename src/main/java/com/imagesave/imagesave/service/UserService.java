package com.imagesave.imagesave.service;
import org.springframework.stereotype.Service;



import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.LoginRequest;

@Service
public interface UserService {

    ApiResponse<?> login(LoginRequest loginRequest);

    void createMainUser();
}
