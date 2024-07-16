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
    public List<CoursesClassify> getAllUser() {
        return coursesClassifyRepository.findAll();
    }

    @Override
    public CoursesClassify getById(Integer id) {
        return coursesClassifyRepository.findById(id).orElse(null);
    }

    @Override
    public void addCoursesClassify(CoursesClassify coursesClassify) {
        coursesClassifyRepository.save(coursesClassify);
    }

    @Override
    public void updateCoursesClassify(CoursesClassify coursesClassify) {
        coursesClassifyRepository.save(coursesClassify);
    }

    @Override
    public void deleteCoursesClassify(CoursesClassify coursesClassify) {
        coursesClassifyRepository.save(coursesClassify);
    }
}
