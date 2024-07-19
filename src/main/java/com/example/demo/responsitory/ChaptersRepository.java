package com.example.demo.responsitory;

import com.example.demo.entity.Chapters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChaptersRepository extends JpaRepository<Chapters, Integer> {
    @Query("SELECT us FROM Chapters us where us.chapterName like %:keyword%")
    List<Chapters> findByChapterName(@Param("keyword") String keyword);
}
