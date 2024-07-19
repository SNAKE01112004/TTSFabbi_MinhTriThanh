package com.example.demo.services.servicesimpl;

import com.example.demo.entity.CoursesClassify;
import com.example.demo.responsitory.CoursesClassifyRepository;
import com.example.demo.services.CoursesClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesClassifyServiceimpl implements CoursesClassifyService {
    @Autowired
    private CoursesClassifyRepository coursesClassifyRepository;

    @Override
    public List<CoursesClassify> getAllCoursesClassify() {
        return coursesClassifyRepository.findAll();
    }
}
