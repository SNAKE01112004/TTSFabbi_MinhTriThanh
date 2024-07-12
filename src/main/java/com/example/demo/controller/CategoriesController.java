package com.example.demo.controller;

import com.example.demo.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/categories")
    private String Home (Model model) {
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        return "/Categories/categories";
    }

    @GetMapping("/view-categories")
    private String HomeCategories (Model model) {
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        return "/Categories/categories";
    }

    @GetMapping("/view-createCategories")
    private String CreteCategories (Model model) {
        return "createCategories";
    }
}
