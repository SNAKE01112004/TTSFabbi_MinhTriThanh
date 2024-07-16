package com.example.demo.responsitory;

import com.example.demo.entity.CoursesClassify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesClassifyRepository extends JpaRepository<CoursesClassify, Integer> {
}
