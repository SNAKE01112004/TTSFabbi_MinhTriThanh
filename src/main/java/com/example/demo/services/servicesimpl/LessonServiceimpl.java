package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Lessons;
import com.example.demo.responsitory.LessonsRepository;
import com.example.demo.services.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceimpl implements LessonsService {
    @Autowired
    private LessonsRepository lessonsRepository;

    @Override
    public List<Lessons> findLessonsByChapterId(Integer chapterId) {
        return lessonsRepository.findLessonsByChapterId(chapterId);
    }

    @Override
    public void saveAndUpdate(Lessons lessons) {
        lessonsRepository.save(lessons);
    }

    @Override
    public void deleteLesson(Lessons lessons) {
        lessonsRepository.delete(lessons);
    }
}
