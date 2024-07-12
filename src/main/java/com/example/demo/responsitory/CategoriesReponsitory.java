package com.example.demo.responsitory;

import com.example.demo.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesReponsitory extends JpaRepository<Categories, Integer> {

}
