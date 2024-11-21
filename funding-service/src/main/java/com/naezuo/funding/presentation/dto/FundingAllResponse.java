package com.naezuo.funding.presentation.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FundingAllResponse {
    private Long Id;
    private Long amount;
    private Integer count;
    private Long userId;
    private Long goodsId;
}
