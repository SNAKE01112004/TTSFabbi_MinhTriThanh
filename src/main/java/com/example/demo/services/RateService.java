package com.example.demo.services;

import com.example.demo.entity.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RateService {
    List<Rate> getAllRate();
    Page<Rate> getAllListRate(Pageable pageable);
    List<Rate> searchByRateCode(String keyword);
    Rate getById(Integer id);
    void saveAndUpdate(Rate rate);
}
