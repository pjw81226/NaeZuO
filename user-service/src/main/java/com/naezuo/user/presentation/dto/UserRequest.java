package com.naezuo.user.presentation.dto;

import com.naezuo.user.domain.enums.Role;
import com.naezuo.user.domain.enums.Sex;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotBlank(message = "User ID를 입력하세요")
    private String userId;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String pw;

    @NotBlank(message = "나이를 입력하세요")
    private Integer age;

    @NotBlank(message = "성별을 입력하세요 (W, M)")
    private Sex sex;

    @NotBlank(message = "이름을 입력하세요")
    private String name;

    @NotBlank(message = "유형을 입력하세요 (NORMAL, INFLUENCER)")
    private Role role;
}
