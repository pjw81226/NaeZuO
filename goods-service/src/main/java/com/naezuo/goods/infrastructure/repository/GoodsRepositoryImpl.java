package com.naezuo.goods.infrastructure.repository;

import com.naezuo.goods.application.interfaces.GoodsRepository;
import com.naezuo.goods.domain.Goods;
import com.naezuo.goods.domain.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GoodsRepositoryImpl implements GoodsRepository {
    private final JpaGoodsRepository jpaGoodsRepository;

    @Override
    public List<Goods> findGoodsING() {
        return jpaGoodsRepository.findGoodsByState(State.ING);
    }

    @Override
    public List<Goods> findGoodsEND() {
        return jpaGoodsRepository.findGoodsByState(State.END);
    }
}
