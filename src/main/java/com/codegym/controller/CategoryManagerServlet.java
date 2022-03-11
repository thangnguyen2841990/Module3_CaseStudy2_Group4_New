package com.codegym.controller;

import com.codegym.Service.CategoryManagerService.CategoryService;
import com.codegym.Service.CategoryManagerService.ICategoryService;
import com.codegym.Service.StoryManagerService.IStoryManagerService;
import com.codegym.Service.StoryManagerService.StoryManagerService;
import com.codegym.dao.StoryManager.StoryManagerDAO;
import com.codegym.dao.category.CategoryDAO;
import com.codegym.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/categories")
public class CategoryManagerServlet extends HttpServlet {
    private ICategoryService categoryService;
    private IStoryManagerService storyManagerService;

    public CategoryManagerServlet() {
        this.categoryService = new CategoryService(new CategoryDAO());
        this.storyManagerService = new StoryManagerService(new StoryManagerDAO());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            default:
                showListCategory(request, response);
                break;
        }
    }

    private void showListCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories",categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            default:
                break;
        }
    }
}
