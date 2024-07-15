package com.example.demo.services;

import com.example.demo.entity.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoriesService {
    List<Categories> getAllCategories();
    List<Categories> searchByCategoriesName(String keyword);
    Page<Categories> getAllListCategories(Pageable pageable);
    Categories getById(Integer id);
    void addCategories(Categories categories);
    void updateCategories(Categories categories);
    void deleteCategories(Categories categories);
    Optional<Categories> getOneCategories(Integer id);
}
