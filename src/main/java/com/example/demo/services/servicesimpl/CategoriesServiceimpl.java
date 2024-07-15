package com.example.demo.services.servicesimpl;

import com.example.demo.entity.Categories;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.Users;
import com.example.demo.responsitory.CategoriesReponsitory;
import com.example.demo.responsitory.UsersReponsitory;
import com.example.demo.services.CategoriesService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// đag thêm sửa xoá=))

@Service
public class CategoriesServiceimpl implements CategoriesService {
    @Autowired
    private CategoriesReponsitory categoriesReponsitory;

    @Override
    public Page<Categories> getAllListCategories(Pageable pageable) { return categoriesReponsitory.findAll(pageable); }

    @Override
    public List<Categories> getAllCategories() {
        return categoriesReponsitory.findAll();
    }

    @Override
    public List<Categories> searchByCategoriesName(String keyword) {return categoriesReponsitory.findByCategoriesName(keyword); }

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

    @Override
    public Optional<Categories> getOneCategories(Integer id) {
        return categoriesReponsitory.findById(id);
    }
}
