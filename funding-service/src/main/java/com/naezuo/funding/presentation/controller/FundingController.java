package com.naezuo.funding.presentation.controller;

import com.naezuo.funding.application.service.FundingService;
import com.naezuo.funding.presentation.dto.ApiResponse;
import com.naezuo.funding.presentation.dto.FundingRequest;
import com.naezuo.funding.presentation.dto.FundingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FundingController {
    private final FundingService fundingService;

    @GetMapping()
    public ResponseEntity<ApiResponse> sayHi() {
        log.info("get / enter");
        return ApiResponse.response(HttpStatus.OK, "펀딩 서비스가 정상 동작합니다.");
    }

    @PostMapping() // 펀딩하기 기능
    public ResponseEntity<ApiResponse> fund(@RequestBody FundingRequest fundingRequest) {
        log.info("post / enter");
        Long fundingId = fundingService.fund(fundingRequest);
        return ApiResponse.response(HttpStatus.OK, "펀딩 성공", new FundingResponse(fundingId));
    }

    @GetMapping("/my-fundings/{userId}")
    public ResponseEntity<ApiResponse> getMyFundings(@PathVariable("userId") Long userId) {
        return ApiResponse.response(HttpStatus.OK, "내 펀딩 목록", fundingService.getMyFundings(userId));
    }
}
