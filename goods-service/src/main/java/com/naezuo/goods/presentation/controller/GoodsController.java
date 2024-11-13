package com.naezuo.goods.presentation.controller;

import com.naezuo.goods.presentation.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GoodsController {
    @GetMapping("/api/v1/test")
    public ResponseEntity<?> response() {
        return ApiResponse.response(HttpStatus.NOT_FOUND, "Not Found");
    }
}
