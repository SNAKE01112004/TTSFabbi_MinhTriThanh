package com.example.demo.responsitory;

import com.example.demo.entity.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercisesRepositotory extends JpaRepository<Exercises, Integer> {
    @Query("SELECT COUNT(e) FROM Exercises e WHERE e.lesson.lessonId IN " +
            "(SELECT l.lessonId FROM Lessons l WHERE l.chapter.chapterId = :chapterId)")
    int countByChapterId(@Param("chapterId") Integer chapterId);

    @Query("SELECT e FROM Exercises e WHERE e.lesson.lessonId IN " +
            "(SELECT l.lessonId FROM Lessons l WHERE l.chapter.chapterId = :chapterId)")
    List<Exercises> findExercisesByChapterAndLesson(@Param("chapterId") Integer chapterId);
}
