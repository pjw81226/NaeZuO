package com.naezuo.user.presentation.controller;

import com.naezuo.user.application.service.UserService;
import com.naezuo.user.presentation.dto.ApiResponse;
import com.naezuo.user.presentation.dto.UserLoginRequest;
import com.naezuo.user.presentation.dto.UserRequest;
import com.naezuo.user.presentation.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<ApiResponse> signUp(@RequestBody UserRequest request){
        userService.signUp(request);
        return ApiResponse.response(HttpStatus.OK,"회원가입이 완료되었습니다.");
    }

    @PostMapping("/signIn")
    public ResponseEntity<ApiResponse> signIn(@RequestBody UserLoginRequest request){
        Optional<UserResponse> response = userService.signIn(request);
        return response
                .map(userResponse -> ApiResponse.response(HttpStatus.OK, "로그인 성공", userResponse))
                .orElseGet(() -> ApiResponse.response(HttpStatus.BAD_REQUEST, "로그인 실패"));
    }
}
