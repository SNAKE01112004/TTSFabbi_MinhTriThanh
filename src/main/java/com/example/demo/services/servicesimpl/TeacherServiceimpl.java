package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Teacher;
import com.example.demo.responsitory.TeacherReponsitory;
import com.example.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// đag thêm sửa xoá=))

@Service
public class TeacherServiceimpl implements TeacherService {
    @Autowired
    private TeacherReponsitory teacherResponsitory;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherResponsitory.findAll();
    }
}
