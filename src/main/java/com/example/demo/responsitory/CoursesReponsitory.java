package com.example.demo.responsitory;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesReponsitory extends JpaRepository<Courses, Integer> {
     Page<Courses> findAll(Pageable pageable);
}
