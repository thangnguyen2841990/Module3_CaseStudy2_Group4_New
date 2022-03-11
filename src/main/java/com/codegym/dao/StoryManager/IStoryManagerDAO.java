package com.codegym.dao.StoryManager;

import com.codegym.dao.IGeneralDAO;
import com.codegym.model.Story;

import java.util.List;

public interface IStoryManagerDAO extends IGeneralDAO<Story> {
    List<Story> findAllProductByName(String name);
}
