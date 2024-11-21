package com.naezuo.goods.presentation.dto;

import com.naezuo.goods.domain.enums.State;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GoodsResponse {
    private String name;
    private Long cost;
    private Long goalAmount;
    private Long totalAmount;
    private Integer totalCount;
    private String imageUrl;
    private State state;
    private String description;
    private String category;
}
