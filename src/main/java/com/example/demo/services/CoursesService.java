package com.example.demo.services;

import com.example.demo.entity.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface CoursesService {
    List<Courses> GetAllCourses();
    Page<Courses> getAllListCourses(Pageable pageable);
    Page<Courses> getAllListCoursesByDeleted(Pageable pageable);
    @Transactional
    void updateDeletedFlag(Integer coursesId,Integer deletedFlag);
    List<Courses> searchByCoursesName(String keyword);
    List<Courses> findCoursesByType(int type);
    Courses getById(Integer id);
    void addCourses(Courses courses);
    void updateCourses(Courses courses);
    void deleteCourses(Courses courses);
}
