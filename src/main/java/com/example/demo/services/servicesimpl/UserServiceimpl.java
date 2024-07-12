package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Users;
import com.example.demo.responsitory.UsersReponsitory;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UsersReponsitory usersResponsitory;

    @Override
    public Page<Users> getAllListUser(Pageable pageable) { return usersResponsitory.findAll(pageable); }

    @Override
    public List<Users> getAllUser() {
        return usersResponsitory.findAll();
    }
    public List<Users> searchByUsersCode(String keyword) {
        return usersResponsitory.findByUsersCode(keyword);
    }

    @Override
    public Users getById(Integer id) {
        return usersResponsitory.findById(id).orElse(null);
    }

    @Override
    public void addUser(Users user) {usersResponsitory.save(user) ;}

    @Override
    public void updateUser(Users user) { usersResponsitory.save(user); }

    @Override
    public void deleteUser(Users user) { usersResponsitory.delete(user); }
}
