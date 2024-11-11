package com.naezuo.goods.application.service;

import com.naezuo.goods.application.interfaces.GoodsRepository;
import com.naezuo.goods.application.mapper.GoodsMapper;
import com.naezuo.goods.presentation.dto.GoodsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsService {
    private final GoodsRepository goodsRepository;


    public List<GoodsResponse> getMyGoods(Long userId) {
        return goodsRepository.getMyGoods(userId).stream().map(GoodsMapper::toDto).toList();
    }

    public List<GoodsResponse> getGoodsING() {
        return goodsRepository.findGoodsING().stream().map(GoodsMapper::toDto).toList();
    }

    public List<GoodsResponse> getGoodsEND() {
        return goodsRepository.findGoodsEND().stream().map(GoodsMapper::toDto).toList();
    }
}
