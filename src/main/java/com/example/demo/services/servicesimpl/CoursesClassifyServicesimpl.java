package com.example.demo.services.servicesimpl;

import com.example.demo.entity.CoursesClassify;
import com.example.demo.responsitory.CoursesClassifyReponsitory;
import com.example.demo.services.CoursesClassifyServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CoursesClassifyServicesimpl implements CoursesClassifyServices {
    @Autowired
    private CoursesClassifyReponsitory coursesClassifyReponsitory;
    @Override
    public List<CoursesClassify> getAllCoursesClassify() {
        return null;
    }

    @Override
    public CoursesClassify getById(Integer CoursesClassifyId) {
        return null;
    }

    @Override
    public void addCoursesClassify(CoursesClassify coursesClassify) {

    }

    @Override
    public void updateCoursesClassify(CoursesClassify coursesClassify) {

    }

    @Override
    public void deleteCoursesClassify(CoursesClassify coursesClassify) {

    }
}
