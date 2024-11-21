package com.naezuo.goods.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsRegisterRequest {
    @NotBlank(message = "혁준형 user id도 같이 넘겨줘잉 ㅠ") // 쿠키로 넘겨줄거면 수정할 부분
    private Long userId;

    @NotBlank(message = "상품명을 입력하세요.")
    private String name;

    @NotBlank(message = "가격을 입력하세요")
    private Long cost;

    @NotBlank(message = "상품 이미지 url을 입력하세요")
    private String imageUrl;

    @NotBlank(message = "목표 금액을 입력하세요")
    private Long goalAmount;

    @NotBlank(message = "상품 설명을 입력하세요")
    private String description;

    @NotBlank(message = "카테고리를 입력하세요")
    private String category;
}
