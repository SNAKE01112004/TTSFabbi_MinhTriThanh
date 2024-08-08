package com.example.demo.services.servicesimpl;

import com.example.demo.entity.CampaignVouchers;
import com.example.demo.responsitory.CampaignRepository;
import com.example.demo.services.CampaignVouchersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignVouchersServiceImpl implements CampaignVouchersService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Override
    public List<CampaignVouchers> getAllUser() {
        return campaignRepository.findAll();
    }
}
