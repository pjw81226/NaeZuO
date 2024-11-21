package com.naezuo.goods.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditorRequest {
    @NotBlank(message = "userId를 입력해주세요")
    private Long userId;
    @NotBlank(message = "json 을 입력해주세요")
    private String json;
}
