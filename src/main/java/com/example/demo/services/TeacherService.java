package com.example.demo.services;

import com.example.demo.entity.StaffCskh;
import com.example.demo.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<Teacher> getAllTeacher();
}
