package com.naezuo.funding.presentation.dto;

public record FundingRequest(
        Long userId,
        Long goodsId,
        Long amount,
        Integer count
) {
}
