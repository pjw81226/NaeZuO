package com.naezuo.goods.application.mapper;

import com.naezuo.goods.domain.Goods;
import com.naezuo.goods.domain.enums.State;
import com.naezuo.goods.presentation.dto.GoodsRequest;
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

    public static Goods toDomain(GoodsRequest goodsRequest){
        return Goods.builder()
                .name(goodsRequest.getName())
                .userId(goodsRequest.getUserId())
                .cost(goodsRequest.getCost())
                .goalAmount(goodsRequest.getGoalAmount())
                .state(State.ING)
                .totalAmount((0L))
                .totalCount(0)
                .imageUrl(goodsRequest.getImageUrl())
                .build();
    }
}
