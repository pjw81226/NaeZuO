package com.naezuo.goods.infrastructure.repository;

import com.naezuo.goods.domain.Goods;
import com.naezuo.goods.domain.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaGoodsRepository extends JpaRepository<Goods, Long> {
    List<Goods> findGoodsByState(State state);

    List<Goods> findGoodsByUserId(Long userId);

    Optional<Goods> getGoodsById(Long id);
}
