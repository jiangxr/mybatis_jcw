package com.jcw.servlet;

import com.jcw.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by jiangchangwei on 2017/5/25.
 */
public class DeleteBatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("zzzzzzzzzzzzzzzzz");
        String[] ids = request.getParameterValues("id");
        System.out.println("IDS："  + Arrays.toString(ids));
        MaintainService maintainService = new MaintainService();
        maintainService.deleteBatch(ids);
        request.getRequestDispatcher("/List.action").forward(request, response);
    }
}
