package com.naezuo.user.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMyPageRequest {
    @NotBlank(message = "User ID를 입력하세요")
    private Long userId;
}
