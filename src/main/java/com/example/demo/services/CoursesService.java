package com.example.demo.services;

import com.example.demo.entity.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoursesService {
    List<Courses> GetAllCourses();
    Page<Courses> getAllListCourses(Pageable pageable);
    List<Courses> searchByCoursesName(String keyword);
    Courses getById(Integer id);
    void addCourses(Courses courses);
    void updateCourses(Courses courses);
    void deleteCourses(Courses courses);
}
