package com.naezuo.funding.infrastructure.repository;

import com.naezuo.funding.application.interfaces.FundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FundingRepositoryImpl implements FundingRepository {
    private final JpaFundingRepository jpaFundingRepository;


}
