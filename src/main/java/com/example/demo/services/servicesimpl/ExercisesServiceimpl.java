package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Exercises;
import com.example.demo.responsitory.ExercisesRepositotory;
import com.example.demo.services.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesServiceimpl implements ExercisesService {
    @Autowired
    private ExercisesRepositotory exercisesRepositotory;

    @Override
    public List<Exercises> getAllExercises() {
        return exercisesRepositotory.findAll();
    }

    @Override
    public Exercises getById(Integer id) {
        return exercisesRepositotory.findById(id).orElse(null);
    }

    @Override
    public void addAndUpdate(Exercises exercises) {
        exercisesRepositotory.save(exercises);
    }

    @Override
    public void deleteExercises(Exercises exercises) {
        exercisesRepositotory.save(exercises);
    }

    @Override
    public int countByChapterId(Integer id) {
        return exercisesRepositotory.countByChapterId(id);
    }

    @Override
    public List<Exercises> findExercisesByChapterAndLesson(Integer chapterId) {
        return exercisesRepositotory.findExercisesByChapterAndLesson(chapterId);
    }
}
