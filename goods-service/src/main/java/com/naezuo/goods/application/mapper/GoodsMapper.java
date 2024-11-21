package com.naezuo.goods.application.mapper;

import com.naezuo.goods.domain.Goods;
import com.naezuo.goods.domain.enums.State;
import com.naezuo.goods.presentation.dto.GoodsRegisterRequest;
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
                .description(domain.getDescription())
                .build();
    }

    public static Goods toDomain(GoodsRegisterRequest goodsRegisterRequest){
        return Goods.builder()
                .name(goodsRegisterRequest.getName())
                .userId(goodsRegisterRequest.getUserId())
                .cost(goodsRegisterRequest.getCost())
                .goalAmount(goodsRegisterRequest.getGoalAmount())
                .state(State.ING)
                .totalAmount((0L))
                .totalCount(0)
                .imageUrl(goodsRegisterRequest.getImageUrl())
                .description(goodsRegisterRequest.getDescription())
                .build();
    }
}
