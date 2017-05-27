package com.jcw.servlet;

import com.jcw.bean.Message;
import com.jcw.service.ListService;

import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangchangwei on 2017/5/24.
 */
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String command = request.getParameter("command");
        String description = request.getParameter("description");
        ListService listService = new ListService();
        //查询消息传递给页面
        request.setAttribute("messageList", listService.queryMessageList(command, description));
        //向页面跳转
        request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
