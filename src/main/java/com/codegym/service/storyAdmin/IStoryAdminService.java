package com.codegym.service.storyAdmin;

import com.codegym.model.Story;

import java.util.List;

public interface IStoryAdminService {
    List<Story> findAllStory();
}
