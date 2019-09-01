package com.lu.servlet;

import com.lu.exception.ParameterException;
import com.lu.tools.DbUtil;
import com.lu.tools.JsonUtil;
import com.lu.vo.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }


    @Override
    public Object process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Article> list = new ArrayList<>();
        //处理前段
        String sid = request.getParameter("id");
        Integer id = null;
        try {
            id = Integer.parseInt(sid);
        } catch (NumberFormatException e) {
            throw new ParameterException("id错误" + sid);
        }
        try {
            connection = DbUtil.getConnection();
            String sql = "select a.id,a.title,a.content,a.create_time" +
                    " from article a join user u on a.user_id = u.id where u.id=?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setCreate_time(resultSet.getTimestamp("create_time"));
                list.add(article);
            }
        } finally {
            DbUtil.close(connection, statement, resultSet);
        }
        return list;
    }
}
