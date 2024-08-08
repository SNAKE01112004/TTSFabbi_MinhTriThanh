package com.example.demo.responsitory;

import com.example.demo.entity.CampaignVouchers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<CampaignVouchers, Integer> {
}
