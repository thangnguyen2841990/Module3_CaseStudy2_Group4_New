package com.codegym.dao.category;

import com.codegym.dao.DBConnection;
import com.codegym.model.Category;
import com.codegym.model.Story;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    public static final String SELECT_FROM_CATEGORY_WHERE_ID = "SELECT * FROM category WHERE id = ?";
    DBConnection dbConnection = new DBConnection();
    Connection connection = dbConnection.getConnection();

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findCategoryById(int id) {
        Category category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CATEGORY_WHERE_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
