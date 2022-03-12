package com.codegym.dao.storyAdmin;

import com.codegym.model.Story;

import java.util.List;

public interface IStoryAdminDAO {
    List<Story> findAllStory();
}
