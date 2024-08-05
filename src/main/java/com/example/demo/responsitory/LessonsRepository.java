package com.example.demo.responsitory;

import com.example.demo.entity.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons, Integer> {
    @Query("SELECT l FROM Lessons l where l.chapter.chapterId = :chapterId")
    List<Lessons> findLessonsByChapterId(@Param("chapterId") Integer chapterId);

    @Query("SELECT count(l) FROM Lessons l where l.chapter.chapterId = :chapterId")
    int getCountLessonsByChapterId(@Param("chapterId") Integer chapterId);


}
