package com.codegym.dao.storyAdmin;

import com.codegym.dao.DBConnection;
import com.codegym.model.Story;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoryAdminDAO implements IStoryAdminDAO{
    public static final String SELECT_FROM_STORY_JOIN_CATEGORY_ON_STORY_ID_CATEGORY_ID = "SELECT * FROM story INNER JOIN category ON story.categoryId = category.id";
    DBConnection dbConnection = new DBConnection();
    Connection connection = dbConnection.getConnection();

    @Override
    public List<Story> findAllStory() {
        List<Story> stories = new ArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_STORY_JOIN_CATEGORY_ON_STORY_ID_CATEGORY_ID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int categoryId = rs.getInt("categoryId");
                String categoryName = rs.getString("category.name");
                String img = rs.getString("img");
                String storyName = rs.getString("story.name");
                int price = rs.getInt("price");
                String writer = rs.getString("author");
                String dateSubmited = rs.getString("dateSubmitted");
                stories.add(new Story(id, categoryId,categoryName,img,storyName,price,writer,dateSubmited));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stories;
    }
}
