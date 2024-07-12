package com.example.demo.services;

import com.example.demo.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<Users> getAllUser();
    Page<Users> getAllListUser(Pageable pageable);
    List<Users> searchByUsersCode(String keyword);
    Users getById(Integer id);
    void addUser(Users user);
    void updateUser(Users user);
    void deleteUser(Users user);
}
