package com.example.demo.services;

import com.example.demo.entity.Staff;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StaffService {
    List<Staff> getAllStaff();

}
