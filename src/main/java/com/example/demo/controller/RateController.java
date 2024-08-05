package com.example.demo.controller;

import com.example.demo.entity.Rate;
import com.example.demo.services.CoursesService;
import com.example.demo.services.ExercisesService;
import com.example.demo.services.RateService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/rate")
public class RateController {

    @Autowired
    UserService userService;

    @Autowired
    CoursesService coursesService;

    @Autowired
    ExercisesService exercisesService;

    @Autowired
    RateService rateService;

    @GetMapping("")
    private String view_Home(Model model) {
        List<Rate> rateList = rateService.getAllRate();
        model.addAttribute("rateList", rateService.getAllRate());
        model.addAttribute("userList", userService.getAllUser());
        model.addAttribute("coursesName", coursesService.GetAllCourses());
        model.addAttribute("exercisesList", exercisesService.getAllExercises());

        return "/Rate/rate";
    }

    @GetMapping("/viewValue")
    private String view_Value() {
        return "/Rate/value";
    }
}


