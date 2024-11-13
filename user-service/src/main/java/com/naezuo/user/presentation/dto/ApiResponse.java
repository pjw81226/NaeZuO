package com.naezuo.user.presentation.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record ApiResponse(String message, Object data) {


    public static ResponseEntity<ApiResponse> response(HttpStatus status, String message){
        return ResponseEntity.status(status).body(new ApiResponse(message, null));
    }

    public static ResponseEntity<ApiResponse> response(HttpStatus status, String message, Object data){
        return ResponseEntity.status(status).body(new ApiResponse(message, data));
    }
}
