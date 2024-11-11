package com.naezuo.funding.infrastructure.repository;

import com.naezuo.funding.domain.Funding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFundingRepository extends JpaRepository<Funding, Long> {
}
