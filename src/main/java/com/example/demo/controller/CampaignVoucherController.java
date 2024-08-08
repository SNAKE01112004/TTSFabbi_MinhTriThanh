package com.example.demo.controller;

import com.example.demo.entity.CampaignVouchers;
import com.example.demo.services.CampaignVouchersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/campaign")
public class CampaignVoucherController {

    @Autowired
    CampaignVouchersService campaignVouchersService;

    @GetMapping()
    private String view_Home(Model model) {
        List<CampaignVouchers> campaignVouchersList = campaignVouchersService.getAllUser();

        model.addAttribute("listCampaign", campaignVouchersList);
        return "/Campaign/campaign";
    }
}
