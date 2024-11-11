package com.naezuo.goods.infrastructure.repository;

import com.naezuo.goods.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaGoodsRepository extends JpaRepository<Goods, Long> {
}
