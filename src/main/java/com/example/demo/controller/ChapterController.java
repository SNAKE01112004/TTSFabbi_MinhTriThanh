package com.example.demo.controller;

import com.example.demo.entity.Chapters;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Lessons;
import com.example.demo.services.ChapterService;
import com.example.demo.services.CoursesService;
import com.example.demo.services.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses/detail")
public class ChapterController {
    @Autowired
    ChapterService chapterService;

    @Autowired
    CoursesService coursesService;

    @Autowired
    LessonsService lessonsService;

    @GetMapping("/{coursesId}/chapter")
    private String view_Home(@PathVariable("coursesId") Integer coursesId, Model model) {
        Courses courses = coursesService.getById(coursesId);
        model.addAttribute("coursesName", courses.getCoursesName());
        model.addAttribute("listChapter", chapterService.findByCoursesId(coursesId));
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

