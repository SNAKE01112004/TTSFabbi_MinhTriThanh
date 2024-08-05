package com.example.demo.controller;


import com.example.demo.entity.Chapters;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Exercises;
import com.example.demo.entity.Lessons;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses/detail/{coursesId}/chapter/{chapterId}/exercises")
public class ExercisesController {
    @Autowired
    ExercisesService exercisesService;

    @Autowired
    LessonsService lessonsService;

    @Autowired
    CoursesService coursesService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ChapterService chapterService;

    @GetMapping("")
    private String viewExercises (@PathVariable("coursesId") Integer coursesId,
                                  @PathVariable("chapterId") Integer chapterId,
                                  Model model) {
        Chapters chapters = chapterService.getById(chapterId);
        Courses courses = coursesService.getById(coursesId);

        model.addAttribute("exerciseList",exercisesService.findExercisesByChapterAndLesson(chapterId));
        model.addAttribute("coursesName",courses.getCoursesName());
        model.addAttribute("chapterName",chapters.getChapterName());
        model.addAttribute("chapter",chapters);
        return "Lessons/exercises";
    }
    @GetMapping("/create-excercise")
    private String createExerrcise (@PathVariable("coursesId") Integer coursesId,
                                    @PathVariable("chapterId") Integer chapterId,
                                    Model model) {
        Chapters chapters = chapterService.getById(chapterId);
        Courses courses = coursesService.getById(coursesId);

        model.addAttribute("excercise",new Exercises());
        model.addAttribute("listTeacher",teacherService.getAllTeacher());
        model.addAttribute("chapterName",chapters.getChapterName());
        model.addAttribute("coursesName",courses.getCoursesName());
        return "Lessons/createExercises";
    }
    @PostMapping("/add-excercise")
    private String addExcercise(@ModelAttribute("excercise") Exercises excercise,
                                @PathVariable("coursesId") Integer coursesId,
                                @PathVariable("chapterId") Integer chapterId){
        Chapters chapters = chapterService.getById(chapterId);
        for (Lessons lessons: lessonsService.findLessonsByChapterId(chapterId)) {
            excercise.setLesson(lessons);
        }
        excercise.setChapter(chapters);
        excercise.setDeletedFlag(0);
        exercisesService.addAndUpdate(excercise);
        return "redirect:/courses/detail/"+coursesId+"/chapter/"+chapterId+"/exercises";
    }

}
