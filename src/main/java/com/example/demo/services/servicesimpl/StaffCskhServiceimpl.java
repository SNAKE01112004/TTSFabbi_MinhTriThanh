package com.example.demo.services.servicesimpl;

import com.example.demo.entity.StaffCskh;
import com.example.demo.responsitory.StaffCskhReponsitory;
import com.example.demo.services.StaffCskhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// đag thêm sửa xoá=))

@Service
public class StaffCskhServiceimpl implements StaffCskhService {
    @Autowired
    private StaffCskhReponsitory staffCskhResponsitory;

    @Override
    public List<StaffCskh> getAllStaffCskh() {
        return staffCskhResponsitory.findAll();
    }

}
