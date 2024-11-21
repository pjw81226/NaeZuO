package com.naezuo.goods.application.interfaces;

import com.naezuo.goods.domain.Goods;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository {
    List<Goods> findGoodsING();

    List<Goods> findGoodsEND();

    List<Goods> getAllGoods();
    Optional<Goods> getGoodsById(Long id);
    List<Goods> getMyGoods(Long userId);

    void save(Goods goods);
}
