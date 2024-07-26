package com.example.demo.controller;

import com.example.demo.entity.Chapters;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Lessons;
import com.example.demo.services.ChapterService;
import com.example.demo.services.CoursesService;
import com.example.demo.services.LessonsService;
import com.example.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses/detail")
public class LessonController {
    @Autowired
    LessonsService lessonsService;

    @Autowired
    CoursesService coursesService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ChapterService chapterService;

    @GetMapping("/{coursesId}/chapter/{chapterId}")
    private String view_Home(@PathVariable("coursesId") Integer coursesId,
                             @PathVariable("chapterId") Integer chapterId,
                             Model model) {
        List<Lessons> lessonsList = lessonsService.findLessonsByChapterId(chapterId);
        Courses courses = coursesService.getById(coursesId);
        Chapters chapters = chapterService.getById(chapterId);

        model.addAttribute("lessons", new Lessons());
        model.addAttribute("lessonsList", lessonsList);
        model.addAttribute("coursesName", courses.getCoursesName());
        model.addAttribute("chapterName", chapters.getChapterName());
        model.addAttribute("listTeacher", teacherService.getAllTeacher());

        return "/Lessons/lesson"; // Đảm bảo tên view là chính xác
    }

    @PostMapping("/{coursesId}/chapter/{chapterId}/add-lesson")
    private String add(@PathVariable("coursesId") Integer coursesId,
                       @PathVariable("chapterId") Integer chapterId,
                       @ModelAttribute("lessons") Lessons lessons) {
        lessonsService.saveAndUpdate(lessons);
        return "redirect:/courses/detail/" + coursesId + "/chapter/" + chapterId; // Chuyển hướng đúng URL
    }
}
