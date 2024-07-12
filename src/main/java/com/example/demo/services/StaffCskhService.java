package com.example.demo.services;

import com.example.demo.entity.StaffCskh;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StaffCskhService {
    List<StaffCskh> getAllStaffCskh();
}
