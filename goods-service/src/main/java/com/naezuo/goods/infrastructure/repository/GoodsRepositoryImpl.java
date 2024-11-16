package com.naezuo.goods.infrastructure.repository;

import com.naezuo.goods.application.interfaces.GoodsRepository;
import com.naezuo.goods.domain.Goods;
import com.naezuo.goods.domain.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    @Override
    public Optional<Goods> getGoodsById(Long id) {
        return jpaGoodsRepository.getGoodsById(id);
    }
    @Override
    public List<Goods> getMyGoods(Long userId) {
        return jpaGoodsRepository.findGoodsByUserId(userId);
    }

    @Override
    public void save(Goods goods) {
        jpaGoodsRepository.save(goods);
    }
}
