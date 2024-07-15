package com.example.demo.services;

import com.example.demo.entity.CoursesClassify;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoursesClassifyServices {
    List<CoursesClassify> getAllCoursesClassify();
    CoursesClassify getById(Integer CoursesClassifyId);
    void addCoursesClassify(CoursesClassify coursesClassify);
    void updateCoursesClassify(CoursesClassify coursesClassify);
    void deleteCoursesClassify (CoursesClassify coursesClassify);
}
