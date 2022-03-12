package com.codegym.controller;

import com.codegym.dao.partAdmin.IPartAdminDAO;
import com.codegym.dao.partAdmin.PartAdminDAO;
import com.codegym.model.Part;
import com.codegym.model.PartImage;
import com.codegym.service.PartAdmin.IPartAdminService;
import com.codegym.service.PartAdmin.PartAdminService;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PartAdminServlet", value = "/partadmins")
public class PartAdminServlet extends HttpServlet {
    IPartAdminService partAdminService = new PartAdminService();
    IPartAdminDAO partAdminDAO = new PartAdminDAO();
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
                int id = Integer.parseInt(request.getParameter("id"));
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                int storyId = Integer.parseInt(request.getParameter("storyId"));
                if (categoryId == 1) {
                    List<PartImage> partImages = this.partAdminService.selectAllPartOfStory(storyId, id);
                    request.setAttribute("listImage", partImages);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("partAdmin/updateImagePart.jsp");
                    dispatcher.forward(request, response);
                } else {
                    Part part = partAdminService.findPartById(id);
                    request.setAttribute("part", part);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("partAdmin/updatePart.jsp");
                    dispatcher.forward(request, response);
                }
                break;
            }
            case "delete": {
                break;
            }
            case "viewPart": {
                int storyId1 = Integer.parseInt(request.getParameter("id"));
                List<Part> parts = partAdminService.findAllPart(storyId1);
                request.setAttribute("listPart", parts);
                RequestDispatcher dispatcher = request.getRequestDispatcher("partAdmin/listPart.jsp");
                dispatcher.forward(request, response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {

                break;
            }
            case "update": {
                int storyId = Integer.parseInt(request.getParameter("storyId"));
                int partId = Integer.parseInt(request.getParameter("id"));
                List<PartImage> partImages = this.partAdminService.selectAllPartOfStory(storyId, partId);
                request.setAttribute("listImage", partImages);
              RequestDispatcher dispatcher = request.getRequestDispatcher("/partAdmin/updatePart.jsp");
              dispatcher.forward(request, response);
            }
            case "deleteImg": {
                int id = Integer.parseInt(request.getParameter("id"));
                this.partAdminDAO.deleteImgById(id);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/part")
                break;
            }
            case "viewPart": {
                int storyId1 = Integer.parseInt(request.getParameter("id"));
                List<Part> parts = partAdminService.findAllPart(storyId1);
                request.setAttribute("listPart", parts);
                RequestDispatcher dispatcher = request.getRequestDispatcher("partAdmin/listPart.jsp");
                dispatcher.forward(request, response);
                break;
            }
        }
    }
}
