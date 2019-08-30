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
import java.util.Map;

@WebServlet("/batchUpdateSubmit")
public class BatchUpdateSubmit extends HttpServlet {
    //@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        UserService userService = new UserServiceImpl();
        String[] strings = new String[100];
        int index = 0;
        for (String s : parameterMap.keySet()) {
           strings[index++] = parameterMap.get(s)[0];
        }
        index = 0;
        while (strings[index]!= null) {
            if (strings[index]!= null) {
                User user = new User();
                user.setId(Integer.parseInt(strings[index++]));
                user.setUsername(strings[index++]);
                user.setBirthday(strings[index++]);
                user.setSex(strings[index++]);
                user.setAddress(strings[index++]);
                userService.updateUser(user);
            }
        }
        response.sendRedirect(request.getContextPath() + "/queryUser");
    }
    //循环调用updateUser方法实现批量修改

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
}
