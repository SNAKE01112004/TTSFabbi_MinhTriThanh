package com.example.demo.responsitory;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherReponsitory extends JpaRepository<Teacher,Integer> {

}
