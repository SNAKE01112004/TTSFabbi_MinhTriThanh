package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Courses;
import com.example.demo.responsitory.CoursesReponsitory;
import com.example.demo.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesServiceimpl implements CoursesService {
    @Autowired
    CoursesReponsitory coursesReponsitory;

    @Override
    public List<Courses> GetAllCourses() {
        return coursesReponsitory.findAll();
    }

    @Override
    public Page<Courses> getAllListCourses(Pageable pageable) {
        return coursesReponsitory.findAll(pageable);
    }

    @Override
    public Page<Courses> getAllListCoursesByDeleted(Pageable pageable) {
        return coursesReponsitory.getCoursesByDeletedFlag(pageable);
    }

    @Override
    public void updateDeletedFlag(Integer coursesId, Integer deletedFlag) {
        coursesReponsitory.updateDeletedFlag(coursesId, deletedFlag);
    }

    @Override
    public List<Courses> searchByCoursesName(String keyword) {
        return coursesReponsitory.findByCoursesCode(keyword);
    }


    @Override
    public Courses getById(Integer id) {
        return coursesReponsitory.findById(id).orElse(null);
    }

    @Override
    public void addCourses(Courses courses) {
        coursesReponsitory.save(courses);
    }

    @Override
    public void updateCourses(Courses courses) {
        coursesReponsitory.save(courses);
    }

    @Override
    public void deleteCourses(Courses courses) {
        coursesReponsitory.delete(courses);
    }

    @Override
    public List<Courses> findCoursesByType(int type) {
        return coursesReponsitory.findCoursesByType(type);
    }
}
