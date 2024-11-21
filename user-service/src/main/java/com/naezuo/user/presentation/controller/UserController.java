package com.naezuo.user.presentation.controller;

import com.naezuo.user.application.service.UserService;
import com.naezuo.user.presentation.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<ApiResponse> test(){
        return ApiResponse.response(HttpStatus.OK, "user service 정상 작동중입니다." );
    }
    @PostMapping("/signUp")
    public ResponseEntity<ApiResponse> signUp(@RequestBody UserSignUpRequest request){
        userService.signUp(request);
        return ApiResponse.response(HttpStatus.OK,"회원가입이 완료되었습니다.");
    }

    @PostMapping("/signIn")
    public ResponseEntity<ApiResponse> signIn(@RequestBody UserLoginRequest request){
        Optional<UserSignInResponse> response = userService.signIn(request);
        return response
                .map(userSignInResponse -> ApiResponse.response(HttpStatus.OK, "로그인 성공", userSignInResponse))
                .orElseGet(() -> ApiResponse.response(HttpStatus.BAD_REQUEST, "로그인 실패"));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> myPage(@PathVariable("userId") Long userId){
        Optional<UserResponse> response = userService.myPage(userId);
        return response
                .map(userResponse -> ApiResponse.response(HttpStatus.OK, "유저 정보 조회 성공", userResponse))
                .orElseGet(() -> ApiResponse.response(HttpStatus.BAD_REQUEST, "유저 정보 조회 실패"));
    }
}
