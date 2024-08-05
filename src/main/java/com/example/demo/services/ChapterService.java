package com.example.demo.services;

import com.example.demo.entity.Chapters;

import java.util.List;
import java.util.Optional;

public interface ChapterService {
    List<Chapters> getAllChapter();
    List<Chapters> findByCoursesId(Integer id);
    List<Chapters> searchByUserName(String keyword);
    Chapters getById(Integer id);
    void saveChapters(Chapters chapters);
    void deleteChapters(Chapters chapters);
;
}
