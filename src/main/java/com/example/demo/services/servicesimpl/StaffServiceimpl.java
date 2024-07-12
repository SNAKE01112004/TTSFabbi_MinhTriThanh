package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Staff;
import com.example.demo.responsitory.StaffReponsitory;
import com.example.demo.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// đag thêm sửa xoá=))

@Service
public class StaffServiceimpl implements StaffService {
    @Autowired
    private StaffReponsitory staffResponsitory;

    @Override
    public List<Staff> getAllStaff() {
        return staffResponsitory.findAll();
    }
}
