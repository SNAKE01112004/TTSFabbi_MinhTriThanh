package com.example.demo.controller;

import com.example.demo.entity.Chapters;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Lessons;
import com.example.demo.services.ChapterService;
import com.example.demo.services.CoursesService;
import com.example.demo.services.ExercisesService;
import com.example.demo.services.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courses/detail")
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @Autowired
    CoursesService coursesService;

    @Autowired
    LessonsService lessonsService;

    @Autowired
    ExercisesService exercisesService;

    @GetMapping("/{coursesId}/chapter")
    public String viewHome(@PathVariable("coursesId") Integer coursesId, Model model) {

        Courses courses = coursesService.getById(coursesId);

        List<Chapters> listChapter = chapterService.findByCoursesId(coursesId);

        // Tạo một map để lưu trữ số lượng bài giảng và bài tập cho từng chapter
        Map<Integer, Integer> lessonQuantities = new HashMap<>();
        Map<Integer, Integer> exerciseQuantities = new HashMap<>();

        for (Chapters chapter : listChapter) {
            int lessonCount = lessonsService.getCountLessonsByChapterId(chapter.getChapterId());
            int exerciseCount = exercisesService.countByChapterId(chapter.getChapterId());

            lessonQuantities.put(chapter.getChapterId(), lessonCount);
            exerciseQuantities.put(chapter.getChapterId(), exerciseCount);
        }

        model.addAttribute("coursesName", courses.getCoursesName());
        model.addAttribute("listChapter", listChapter);
        model.addAttribute("lessonQuantity", lessonQuantities);
        model.addAttribute("exerciseQuantity", exerciseQuantities);
        model.addAttribute("coursesId", coursesId);
        return "/Courses/detailCourses";
    }


    @PostMapping("/{coursesId}/chapter/add")
    private String addChapter(@ModelAttribute Chapters chapter,
                              @PathVariable("coursesId") Integer coursesId) {
        Courses courses = coursesService.getById(coursesId);
        chapter.setCourses(courses);
        chapterService.saveChapters(chapter);
        return "redirect:/courses/detail/"+coursesId+"/chapter";
    }
}

