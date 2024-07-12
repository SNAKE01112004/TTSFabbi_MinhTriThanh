package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.Users;
import com.example.demo.responsitory.CategoriesReponsitory;
import com.example.demo.responsitory.UsersReponsitory;
import com.example.demo.services.CategoriesService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// đag thêm sửa xoá=))

@Service
public class CategoriesServiceimpl implements CategoriesService {
    @Autowired
    private CategoriesReponsitory categoriesReponsitory;

    @Override
    public List<Categories> getAllCategories() {
        return categoriesReponsitory.findAll();
    }

    @Override
    public Categories getById(Integer id) {
        return categoriesReponsitory.findById(id).orElse(null);
    }

    @Override
    public void addCategories(Categories categories) {categoriesReponsitory.save(categories) ;}

    @Override
    public void updateCategories(Categories categories) { categoriesReponsitory.save(categories); }

    @Override
    public void deleteCategories(Categories categories) { categoriesReponsitory.delete(categories); }
}
