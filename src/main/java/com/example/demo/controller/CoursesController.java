package com.example.demo.controller;

import com.example.demo.entity.Courses;
import com.example.demo.services.CoursesClassifyService;
import com.example.demo.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @Autowired
    CoursesClassifyService coursesClassifyService;

    @GetMapping()
    private String view_Home(Model model,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);

        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<Courses> coursesPage = coursesService.getAllListCourses(pageable);

        int totalElement = (int) coursesPage.getTotalElements();
        int begin = currentPage * pageSize + 1;
        int end = Math.min((currentPage +1)*pageSize,totalElement);

        model.addAttribute("totalPage", coursesPage.getTotalPages());
        model.addAttribute("begin", begin);
        model.addAttribute("number", currentPage);
        model.addAttribute("end", end);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("listCourses", coursesService.GetAllCourses());
        return "/Courses/courses";
    }
}
