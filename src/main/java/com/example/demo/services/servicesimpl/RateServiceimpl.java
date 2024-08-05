package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Rate;
import com.example.demo.responsitory.RateReponsitory;
import com.example.demo.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RateServiceimpl implements RateService {

    @Autowired
    RateReponsitory rateReponsitory;

    @Override
    public List<Rate> getAllRate() {
        return rateReponsitory.findAll();
    }

    @Override
    public Page<Rate> getAllListRate(Pageable pageable) {
        return rateReponsitory.findAll(pageable);
    }

    @Override
    public List<Rate> searchByRateCode(String keyword) {
        return rateReponsitory.findByCoursesCode(keyword);
    }

    @Override
    public Rate getById(Integer id) {
        return rateReponsitory.findById(id).orElse(null);
    }

    @Override
    public void saveAndUpdate(Rate rate) {
        rateReponsitory.save(rate);
    }
}
