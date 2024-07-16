package com.example.demo.responsitory;

import com.example.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffReponsitory extends JpaRepository<Staff,Integer> {

}
