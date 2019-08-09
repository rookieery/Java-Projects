package com.lu.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 获取数据库的连接，并且执行CRUD
 */
public class DbManager {

    private Connection conn = null;
    private Statement state = null;
    private ResultSet rs = null;

    private String username = "root";
    private String password = ">+1nrM+CoOVj";
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/tt";

    public Connection getConnection(){
        try {
            Class.forName(driver);
            System.out.println("loading driver success.......");
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("connection tools success.....");
            return conn;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return  conn;
    }

    // insert update delete
    public int nonQueryMethod(String strSql){
        int flag = 0;
        try {
            conn = this.getConnection();
            state = conn.createStatement();
            flag = state.executeUpdate(strSql);
            return flag;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }

    public ResultSet queryMethod(String strSql){

        try {
            conn = this.getConnection();
            state = conn.createStatement();
            rs = state.executeQuery(strSql);
            return rs;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }

    public void closeDb(){
        try {
            if(rs != null) rs.close();
            if(state!= null) state.close();
            if(conn != null) conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}

