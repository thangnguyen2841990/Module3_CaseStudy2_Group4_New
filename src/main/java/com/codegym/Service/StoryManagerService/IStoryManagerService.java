package com.codegym.Service.StoryManagerService;

import com.codegym.Service.IGeneralService;
import com.codegym.model.Story;

import java.util.List;

public interface IStoryManagerService extends IGeneralService <Story> {
    List<Story> findAllProductByName (String name);
}
