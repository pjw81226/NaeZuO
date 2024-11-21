package com.naezuo.funding.application.service;

import com.naezuo.funding.application.mapper.FundingMapper;
import com.naezuo.funding.domain.Funding;
import com.naezuo.funding.infrastructure.repository.JpaFundingRepository;
import com.naezuo.funding.presentation.dto.FundingAllResponse;
import com.naezuo.funding.presentation.dto.FundingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FundingService {
    private final JpaFundingRepository jpaFundingRepository;

    @Transactional
    public Long fund(FundingRequest fundingRequest) {
        Funding funding = new Funding(
                fundingRequest.amount(), fundingRequest.count(), fundingRequest.userId(), fundingRequest.goodsId());
        Funding save = jpaFundingRepository.save(funding);
        return save.getId();
    }

    public List<FundingAllResponse> getMyFundings(Long userId) {
        return jpaFundingRepository.getAllByUserId(userId).stream().map(FundingMapper::toFundingAllResponse).toList();
    }
}
