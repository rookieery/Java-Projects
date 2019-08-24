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

@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setUsername(request.getParameter("name"));
        user.setBirthday(request.getParameter("birthday"));
        user.setSex(request.getParameter("sex"));
        user.setAddress(request.getParameter("address"));
        UserService userService = new UserServiceImpl();
        userService.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/queryUser");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}
