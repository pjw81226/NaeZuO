package com.naezuo.user.presentation.dto;

import org.springframework.http.HttpStatus;

public record ApiResponse(HttpStatus status, String message, Object data) {
    public static ApiResponse apiResponse(HttpStatus status, String message, Object data) {
        return new ApiResponse(status, message, data);
    }

    public static ApiResponse apiResponse(HttpStatus status, String message) {
        return new ApiResponse(status, message, null);
    }
}
