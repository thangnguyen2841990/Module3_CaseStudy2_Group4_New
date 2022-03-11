package com.codegym.dao.category;

import com.codegym.dao.DBConnection;
import com.codegym.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO{
    public static final String SELECT_FROM_CATEGORY = "select * from category";
    Connection connection = DBConnection.getConnection();

    public CategoryDAO() {
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CATEGORY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
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
