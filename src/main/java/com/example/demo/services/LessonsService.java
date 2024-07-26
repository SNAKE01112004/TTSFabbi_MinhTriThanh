package com.example.demo.services;

import com.example.demo.entity.Lessons;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonsService {
    List<Lessons> findLessonsByChapterId(Integer id);
    void saveAndUpdate(Lessons lessons);
    void deleteLesson(Lessons lessons);
}
