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
    @GetMapping("/hi")
    public ResponseEntity<ApiResponse> sayHi() {
        return ApiResponse.response(HttpStatus.OK, "hi");
    }}
