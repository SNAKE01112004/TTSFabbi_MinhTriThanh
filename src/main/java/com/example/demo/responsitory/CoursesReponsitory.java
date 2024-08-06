package com.example.demo.responsitory;

import com.example.demo.entity.Courses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CoursesReponsitory extends JpaRepository<Courses, Integer> {
     Page<Courses> findAll(Pageable pageable);

     @Query("SELECT us from Courses us where us.coursesName like %:keyword%")
     List<Courses> findByCoursesCode(@Param("keyword") String keyword);

     @Query("SELECT c FROM Courses c WHERE c.coursesType = :type and c.deletedFlag = 0")
     List<Courses> findCoursesByType(@Param("type") int type);

     @Query(value = "SELECT c from Courses c where c.deletedFlag = 0")
     Page<Courses> getCoursesByDeletedFlag(Pageable pageable);

     @Modifying
     @Transactional
     @Query("update Courses c set c.deletedFlag = :deletedFlag where c.coursesId = :coursesId")
     Integer updateDeletedFlag(@Param("coursesId") Integer coursesId,@Param("deletedFlag") Integer deletedFlag);
}
