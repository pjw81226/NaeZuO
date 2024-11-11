package com.naezuo.funding.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "funding")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Funding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @Column(name = "amount" , nullable = false)
    private Long amount = 0L;

    @Builder.Default
    @Column(name = "count" , nullable = false)
    private Integer count = 0;


    //many to one -> 연관관계편의메서드 할지는 고민중
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "goods_id", nullable = false)
    private Long goodsId;
}
