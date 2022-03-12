package com.codegym.controller;

import com.codegym.model.Part;
import com.codegym.model.Story;
import com.codegym.service.PartAdmin.IPartAdminService;
import com.codegym.service.PartAdmin.PartAdminService;
import com.codegym.service.storyAdmin.IStoryAdminService;
import com.codegym.service.storyAdmin.StoryAdminService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StoryAdminServlet", value = "/storyadmins")
public class StoryAdminServlet extends HttpServlet {
    IStoryAdminService storyAdminService = new StoryAdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                break;
            }
            case "update": {
                break;
            }
            case "delete": {
                break;
            }
            default: {
                List<Story> stories = storyAdminService.findAllStory();
                request.setAttribute("listStory", stories);
                RequestDispatcher dispatcher = request.getRequestDispatcher("storyAdmin/storyAdmin.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
    }
}
