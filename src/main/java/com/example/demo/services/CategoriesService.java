package com.example.demo.services;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriesService {
    List<Categories> getAllCategories();
    Categories getById(Integer id);
    void addCategories(Categories categories);
    void updateCategories(Categories categories);
    void deleteCategories(Categories categories);

}
