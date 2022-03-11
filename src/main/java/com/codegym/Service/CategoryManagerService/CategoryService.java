package com.codegym.Service.CategoryManagerService;

import com.codegym.dao.category.ICategoryDAO;
import com.codegym.model.Category;

import java.util.List;

public class CategoryService implements ICategoryService{
    private ICategoryDAO categoryDAO;

    public CategoryService(ICategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public boolean create(Category category) {
        return false;
    }

    @Override
    public boolean updateById(int id, Category category) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
