package com.imagesave.imagesave.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ApiResponse<T> {

    private String status;
    private String message;
    private T data;



    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>("Success", message, data);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>("failed", message, null);
    }
}
