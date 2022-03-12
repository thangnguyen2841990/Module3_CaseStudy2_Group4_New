package com.codegym.service.storyAdmin;

import com.codegym.dao.storyAdmin.IStoryAdminDAO;
import com.codegym.dao.storyAdmin.StoryAdminDAO;
import com.codegym.model.Story;

import java.util.List;

public class StoryAdminService implements IStoryAdminService {
    IStoryAdminDAO storyAdminDAO = new StoryAdminDAO();

    @Override
    public List<Story> findAllStory() {
        return storyAdminDAO.findAllStory();
    }
}
