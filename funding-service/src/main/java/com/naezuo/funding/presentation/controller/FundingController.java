package com.naezuo.funding.presentation.controller;

import com.naezuo.funding.presentation.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundingController {
    @GetMapping("/test") //url = http://localhost/funding/test
    public ResponseEntity<ApiResponse> sayHi() {
        return ApiResponse.response(HttpStatus.OK, "hi");
    }
}
