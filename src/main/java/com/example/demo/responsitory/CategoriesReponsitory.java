package com.example.demo.responsitory;

import com.example.demo.entity.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesReponsitory extends JpaRepository<Categories, Integer> {
    @Query("SELECT us FROM Categories us where us.categoriesName like %:keyword%")
    List<Categories> findByCategoriesName(@Param("keyword") String keyword);

    Page<Categories> findAll(Pageable pageable);
}
