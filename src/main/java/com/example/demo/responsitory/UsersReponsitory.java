package com.example.demo.responsitory;

import com.example.demo.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersReponsitory extends JpaRepository<Users,Integer> {
    Page<Users> findAll(Pageable pageable);

    @Query("SELECT us FROM Users us where us.usersCode like %:keyword%")
    List<Users> findByUsersCode(@Param("keyword") String keyword);
}
