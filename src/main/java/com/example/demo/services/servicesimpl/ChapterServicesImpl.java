package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Chapters;
import com.example.demo.responsitory.ChaptersRepository;
import com.example.demo.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServicesImpl implements ChapterService {
    @Autowired
    private ChaptersRepository chaptersRepository;

    @Override
    public List<Chapters> getAllChapter() {
        return chaptersRepository.findAll();
    }

    @Override
    public List<Chapters> findByCoursesId(Integer id) {
        return chaptersRepository.findByCoursesId(id);
    }

    @Override
    public List<Chapters> searchByUserName(String keyword) {
        return chaptersRepository.findByChapterName(keyword);
    }

    @Override
    public Chapters getById(Integer id) {
        return chaptersRepository.findById(id).orElse(null);
    }

    @Override
    public void saveChapters(Chapters chapters) {
        chaptersRepository.save(chapters);
    }

    @Override
    public void deleteChapters(Chapters chapters) {
        chaptersRepository.delete(chapters);
    }
}
