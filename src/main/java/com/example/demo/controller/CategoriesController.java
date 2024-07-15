package com.example.demo.controller;

import com.example.demo.entity.Categories;
import com.example.demo.services.CategoriesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;

    @GetMapping()
    private String Home (Model model,
                         @RequestParam("page") Optional<Integer> page,
                         @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10);

        Pageable pageable = (Pageable) PageRequest.of(currentPage, pageSize);
        Page<Categories> categoriesPage = categoriesService.getAllListCategories(pageable);

        int totalElement = (int) categoriesPage.getTotalElements();
        int begin = currentPage * pageSize + 1;
        int end = Math.min((currentPage + 1)*pageSize, totalElement);

        model.addAttribute("totalPage", categoriesPage.getTotalPages());
        model.addAttribute("begin", begin);
        model.addAttribute("number", currentPage);
        model.addAttribute("end", end);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        return "/Categories/categories";
    }

    @GetMapping("/view-create")
    private String addCategories (Model model) {
        model.addAttribute("categories",new Categories());
        return "/Categories/createCategories";
    }
    @PostMapping("/add")
    private String addCategories(@Valid @ModelAttribute("categories") Categories categories,
                                   BindingResult result,
                                   Model model) {
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        categoriesService.addCategories(categories);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{categoriesId}")
    private String delete(@PathVariable("categoriesId") Integer categoriesId, Model model) {
        Categories categories = categoriesService.getById(categoriesId);
        categoriesService.deleteCategories(categories);
        return "redirect:/categories";
    }

    @GetMapping("/view-update/{categoriesId}")
    private String update(@PathVariable("categoriesId") Integer categoriesId, Model model)
    {
        Categories categories = categoriesService.getOneCategories(categoriesId).orElse(null);
        model.addAttribute("categories", categories);
        return "/Categories/updateCategories";
    }

    @PostMapping("/update/{categoriesId}")
    private String updateCategories( @ModelAttribute("categories") Categories categories,
                                 BindingResult result, @PathVariable Integer categoriesId,
                                 Model model) {
        categories.setCategoriesId(categoriesId);
        categoriesService.addCategories(categories);
        return "redirect:/categories";
    }

    @GetMapping("/search")
    private String searchCategories(@RequestParam("keyword") String keyword, Model model) {
        List<Categories> categoriesList;
        if(keyword == null && keyword.isEmpty())
        {
            categoriesList = categoriesService.getAllCategories();
            model.addAttribute("listCategories", categoriesList);
        }
        else {
            categoriesList = categoriesService.searchByCategoriesName(keyword);
            model.addAttribute("listCategories", categoriesList);
        }
        if(categoriesList.isEmpty())
        {
            System.out.println("Found " + categoriesList.size() + " records for catergoriesName: " + keyword);
        }
        return "Categories/categories";
    }
}
