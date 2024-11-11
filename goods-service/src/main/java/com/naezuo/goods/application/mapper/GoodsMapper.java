package com.naezuo.goods.application.mapper;

import com.naezuo.goods.domain.Goods;
import com.naezuo.goods.presentation.dto.GoodsResponse;

public class GoodsMapper {
    public static GoodsResponse toDto(Goods domain){
        return GoodsResponse.builder()
                .name(domain.getName())
                .cost(domain.getCost())
                .goalAmount(domain.getGoalAmount())
                .totalAmount(domain.getTotalAmount())
                .totalCount(domain.getTotalCount())
                .imageUrl(domain.getImageUrl())
                .state(domain.getState())
                .build();
    }
}
