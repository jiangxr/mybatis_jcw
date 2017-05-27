package com.jcw.servlet;

import com.jcw.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jiangchangwei on 2017/5/25.
 */
public class DeleteOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        MaintainService maintainService = new MaintainService();
        maintainService.deleteOne(id);
        request.getRequestDispatcher("/List.action").forward(request, response);
    }
}
