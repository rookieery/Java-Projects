package com.lu.servlet;

import com.lu.tools.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = UEditorServlet.class.getClassLoader().getResource("config.json").getPath();
        MyActionEnter myActionEnter = new MyActionEnter(request,path);
        String exec = myActionEnter.exec();
        response.getWriter().write(exec);
    }
}
