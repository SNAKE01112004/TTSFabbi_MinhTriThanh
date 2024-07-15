package com.example.demo.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesClassifyReponsitory extends JpaRepository<CoursesClassifyReponsitory, Integer> {

}
