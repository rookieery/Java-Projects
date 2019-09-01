package com.lu.servlet;

import com.lu.exception.BusinessException;
import com.lu.exception.ParameterException;
import com.lu.tools.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }


    @Override
    public Object process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        int[] intIds = new int[idArray.length];
        try {
            for (int i = 0; i < idArray.length; i++) {
                intIds[i] = Integer.parseInt(idArray[i]);
            }
        } catch (Exception e) {
            throw new ParameterException("请求参数错误ids=" + ids);
        }
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DbUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in(");
            for (int i = 0; i < intIds.length; i++) {
                if (i == 0) {
                    sql.append("?");
                } else {
                    sql.append(",?");
                }
            }
            sql.append(")");
            statement = connection.prepareStatement(sql.toString());
            for (int i = 0; i < intIds.length; i++) {
                statement.setInt(i + 1, intIds[i]);
            }
            int r = statement.executeUpdate();
            if (r > 0) {
                return r;
            } else {
                throw new BusinessException("没有该用户");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(connection, statement, null);
        }
        return null;
    }

}
