package com.naezuo.user.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequest {
    @NotBlank(message = "User ID를 입력하세요")
    private String userId;
    @NotBlank(message = "비밀번호를 입력하세요")
    private String pw;
}
