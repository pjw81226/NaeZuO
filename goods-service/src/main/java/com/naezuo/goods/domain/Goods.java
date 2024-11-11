package com.naezuo.goods.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "goods")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Builder.Default
    @Column(name = "cost", nullable = false)
    private Long cost = 0L;

    @Builder.Default
    @Column(name = "goal_amount", nullable = false)
    private Long goalAmount = 0L; //목표금액

    @Builder.Default
    @Column(name = "total_amount", nullable = false)
    private Long totalAmount = 0L;

    @Builder.Default
    @Column(name = "total_count", nullable = false)
    private Integer totalCount = 0;

}
