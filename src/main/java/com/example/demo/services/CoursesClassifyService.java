package com.example.demo.services;

import com.example.demo.entity.CoursesClassify;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoursesClassifyService {
    List<CoursesClassify> getAllCoursesClassify();
}
