package com.naezuo.funding.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "funding")
@NoArgsConstructor
@Getter
public class Funding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount" , nullable = false)
    private Long amount = 0L; // 가격

    @Column(name = "count" , nullable = false)
    private Integer count = 0; // 개수

    //many to one -> 연관관계편의메서드 할지는 고민중
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "goods_id", nullable = false)
    private Long goodsId;

    public Funding(Long amount, Integer count, Long userId, Long goodsId) {
        this.amount = amount;
        this.count = count;
        this.userId = userId;
        this.goodsId = goodsId;
    }
}
