package com.codegym.controller;

import com.codegym.Service.CategoryManagerService.CategoryService;
import com.codegym.Service.CategoryManagerService.ICategoryService;
import com.codegym.Service.StoryManagerService.IStoryManagerService;
import com.codegym.Service.StoryManagerService.StoryManagerService;
import com.codegym.dao.StoryManager.StoryManagerDAO;
import com.codegym.dao.category.CategoryDAO;
import com.codegym.model.Category;
import com.codegym.model.Story;

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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCategory(request, response);
                break;
            case "edit":
                showEditCategory(request, response);
                break;
            case "delete":
                showDeleteCategory(request, response);
                break;
            case "view":
                showListStoryByCategory(request, response);
                break;
            default:
                showListCategory(request, response);
                break;
        }
    }

    private void showDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.findById(id);
        request.setAttribute("category",category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.findById(id);
        Category category = categoryService.findById(id);
        request.setAttribute("category",category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showListStoryByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        List<Story> stories = storyManagerService.findAllProductByCategoryId(categoryId);
        request.setAttribute("stories", stories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showListCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        String q = request.getParameter("q");
        if (q != null){
            categories = categoryService.findAllCategoryByName(q);
        }
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCategory(request, response);
                break;
            case "edit":
                editCategory(request, response);
            case "delete":
                deleteCategory(request, response);
            default:
                break;
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryService.deleteById(id);
        response.sendRedirect("categories");
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category(id,name);
        categoryService.updateById(id,category);
        response.sendRedirect("categories");
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        Category category = new Category(name);
        categoryService.create(category);
        response.sendRedirect("categories");
    }
}
