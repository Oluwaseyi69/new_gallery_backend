package com.imagesave.imagesave.controller;

import com.imagesave.imagesave.data.models.User;
import com.imagesave.imagesave.dtos.ApiResponse;
import com.imagesave.imagesave.dtos.LoginRequest;
import com.imagesave.imagesave.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PatchMapping("/login")
    public ApiResponse<?> login(@RequestBody LoginRequest loginRequest) {
        try{
            return userService.login(loginRequest);
        } catch (Exception e){
            return ApiResponse.error(e.getMessage());
        }
    }
}
