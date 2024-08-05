package com.example.demo.services;

import com.example.demo.entity.Exercises;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExercisesService {
    List<Exercises> getAllExercises();
    Exercises getById(Integer id);
    void addAndUpdate(Exercises exercises);
    void deleteExercises(Exercises exercises);
    int countByChapterId(Integer id);
    List<Exercises> findExercisesByChapterAndLesson(Integer chapterId);
}
