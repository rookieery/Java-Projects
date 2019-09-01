package com.lu.tools;

import com.lu.exception.SystemException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
    private static volatile DataSource dataSource;

    private DbUtil() {

    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DbUtil.class) {
                dataSource = new MysqlDataSource();//MySql数据源
                String host = "127.0.0.1";
                String port = "3306";
                ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://" + (host + ":" + port) + "/blogdemo"
                        + "?useUnicode=true&characterEncoding=utf-8&useSSL=false");
                ((MysqlDataSource) dataSource).setUser("root");
                ((MysqlDataSource) dataSource).setPassword("Alu.0812");
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement,
                             ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SystemException("数据库错误");
        }
    }

}
