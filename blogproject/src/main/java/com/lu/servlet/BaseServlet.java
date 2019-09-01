package com.lu.servlet;

import com.lu.exception.ParameterException;
import com.lu.exception.SystemException;
import com.lu.tools.JsonUtil;
import com.lu.vo.Json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=UTF-8");
        Json json = new Json();
        try {
            Object data = process(request, response);
            json.setSuccess(true);
            json.setCode("200");
            json.setMessage("操作成功");
            json.setData(data);
        } catch (Exception e) {
            if (e instanceof ParameterException) {
                json.setCode(((ParameterException) e).getCode());
                json.setMessage(e.getMessage());
            } else if (e instanceof SystemException) {
                json.setCode(((SystemException) e).getCode());
                json.setMessage(e.getMessage());
            } else {
                json.setCode("500");
                json.setMessage("服务器错误");
            }
        }
        response.getWriter().write(JsonUtil.format(json));
        //response.sendRedirect(request.getContextPath() + "/articleList");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    public abstract Object process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException;

}
