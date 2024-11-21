package com.naezuo.goods.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EditorResponse {
    private Long userId;
    private String json;
}
