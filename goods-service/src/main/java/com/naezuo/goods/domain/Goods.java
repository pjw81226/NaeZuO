package com.naezuo.goods.domain;

import com.naezuo.goods.domain.enums.State;
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

    @Column(name="user_id", nullable = false )
    private Long userId;

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

    @Builder.Default
    @Column(name = "state", nullable = false)
    private State state = State.ING;

    @Builder.Default
    @Column(name="image_url", nullable = false)
    private String imageUrl = "";
}
