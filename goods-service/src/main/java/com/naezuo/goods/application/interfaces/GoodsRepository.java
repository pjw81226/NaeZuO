package com.naezuo.goods.application.interfaces;

import com.naezuo.goods.domain.Goods;

import java.util.List;

public interface GoodsRepository {
    List<Goods> findGoodsING();

    List<Goods> findGoodsEND();

    List<Goods> getMyGoods(Long userId);
}
