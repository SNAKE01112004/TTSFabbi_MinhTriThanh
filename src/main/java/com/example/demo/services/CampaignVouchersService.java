package com.example.demo.services;

import com.example.demo.entity.CampaignVouchers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CampaignVouchersService {
    List<CampaignVouchers> getAllUser();
}
