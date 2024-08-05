package com.example.demo.responsitory;

import com.example.demo.entity.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateReponsitory extends JpaRepository<Rate, Integer> {
    Page<Rate> findAll(Pageable pageable);
    @Query("SELECT us from Courses us where us.coursesName like %:keyword%")
    List<Rate> findByCoursesCode(@Param("keyword") String keyword);
}
