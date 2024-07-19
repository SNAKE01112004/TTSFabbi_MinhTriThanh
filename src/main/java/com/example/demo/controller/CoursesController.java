package com.example.demo.controller;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Courses;
import com.example.demo.entity.Users;
import com.example.demo.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CategoriesService categoriesService;

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
        model.addAttribute("listCourses",coursesPage.getContent());
        return "/Courses/courses";
    }

    @GetMapping("/view-create")
    public String addCourses(Model model) {
        model.addAttribute("courses", new Courses());
        model.addAttribute("listTeacher", teacherService.getAllTeacher());
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        model.addAttribute("listCoursesClassify", coursesClassifyService.getAllCoursesClassify());
        return "/Courses/createCourses";
    }

    @PostMapping("/add")
    public String addCourses(@Valid @ModelAttribute("courses") Courses courses,
                             BindingResult result,
                             @RequestParam("program-cost") String programCost,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listTeacher", teacherService.getAllTeacher());
            model.addAttribute("listCategories", categoriesService.getAllCategories());
            model.addAttribute("listCoursesClassify", coursesClassifyService.getAllCoursesClassify());
            return "/Courses/createCourses";
        }

        if ("free".equals(programCost)) {
            courses.setEfectiveDurationMoney(BigDecimal.ZERO); // Set to 0 for free program
        }

        coursesService.addCourses(courses);
        return "redirect:/courses";
    }

    @GetMapping("/detail/{coursesId}")
    private String detail(@PathVariable("coursesId") Integer coursesId, Model model)
    {
        Courses courses = coursesService.getById(coursesId);
        model.addAttribute("courses", courses);
        model.addAttribute("listTeacher", teacherService.getAllTeacher());
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        model.addAttribute("listCoursesClassify", coursesClassifyService.getAllCoursesClassify());
        return "Courses/detailCourses";
    }

    @GetMapping("/search")
    private String searchCourses(@RequestParam("keyword") String keyword, Model model) {
        List<Courses> coursesList;
        if (keyword == null && keyword.isEmpty()) {
            coursesList = coursesService.GetAllCourses();
            model.addAttribute("listCourses", coursesList);
        } else {
            coursesList = coursesService.searchByCoursesName(keyword);
            model.addAttribute("listCourses", coursesList);
        }
        if (coursesList.isEmpty()) {
            System.out.println("No data found for usersCode: " + keyword);
            model.addAttribute("emptyData", "Không có dữ liệu");
        } else {
            System.out.println("Found " + coursesList.size() + " records for usersCode: " + keyword);
        }
        return "/Courses/courses";
    }
}
