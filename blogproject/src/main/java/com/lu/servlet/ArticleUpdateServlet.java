package com.lu.servlet;

import com.lu.exception.BusinessException;
import com.lu.tools.DbUtil;
import com.lu.tools.JsonUtil;
import com.lu.vo.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }


    @Override
    public Object process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        //处理前段
//        String userAccount = request.getParameter("userAccount");
//        String title = request.getParameter("title");
//        String content = request.getParameter("content");
        Article article = JsonUtil.get(request,Article.class);
        System.out.println(article);
        try {
            connection = DbUtil.getConnection();
            String sql = "update article set title=?,content = ? where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getContent());
            statement.setInt(3, article.getId());
            int r = statement.executeUpdate();
            if (r > 0) {
                return r;
            } else {
                throw new BusinessException("没有该文章" + article.getId());
            }
        } finally {
            DbUtil.close(connection, statement, null);
        }
    }
}
