package com.lu.controller;

import com.lu.model.UserService;
import com.lu.model.UserServiceImpl;
import com.lu.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/queryUser")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //执行业务逻辑
        UserService queryUserService = new UserServiceImpl();
        List<User> list = queryUserService.queryUser();
        //转换jsp页面
        request.setAttribute("userListKey",list);
        request.getRequestDispatcher("jsp/list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
