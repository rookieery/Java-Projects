package com.lu.tools;

import java.sql.*;

public class DbManager2 {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis",
                    "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet query(String sql) {
        try {
            Connection connection = this.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int update(String sql) {
        int flag = 0;
        try {
            Connection connection = this.getConnection();
            statement = connection.createStatement();
            flag = statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public void close() {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
