package com.example.demo.controller;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Users;
import com.example.demo.services.CategoriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    @GetMapping("/view-create-categories")
    private String CreteCategories (Model model) {
        model.addAttribute("categories",new Categories());
        return "/Categories/createCategories";
    }
    @PostMapping("/add-categories")
    private String CreteCategories(@Valid @ModelAttribute("categories") Categories categories,
                                   BindingResult result,
                                   Model model) {
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        categoriesService.addCategories(categories);
        return "/Categories/createCategories";
    }
}
