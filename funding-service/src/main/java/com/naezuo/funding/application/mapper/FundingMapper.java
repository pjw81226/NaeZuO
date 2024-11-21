package com.naezuo.funding.application.mapper;

import com.naezuo.funding.domain.Funding;
import com.naezuo.funding.presentation.dto.FundingAllResponse;

public class FundingMapper {
    public static FundingAllResponse toFundingAllResponse(Funding funding) {
        return FundingAllResponse.builder()
                .Id(funding.getId())
                .amount(funding.getAmount())
                .count(funding.getCount())
                .userId(funding.getUserId())
                .goodsId(funding.getGoodsId())
                .build();
    }
}
