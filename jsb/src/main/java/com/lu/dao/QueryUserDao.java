package com.lu.dao;

import com.lu.tools.DbManager;
import com.lu.vo.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryUserDao {
    public List<User> queryUser() {
        //由于User可能不止一个，所以用一个list进行接收
        List<User> list = new ArrayList<>();
        DbManager dbManager = new DbManager();
        try {
            String sql = "select * from user";
            ResultSet rs = dbManager.queryMethod(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setBirthday(rs.getString("birthday"));
                user.setSex(rs.getString("sex"));
                user.setAddress(rs.getString("address"));
                if (user != null) {
                    list.add(user);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbManager.closeDb();
        }
        return list;
    }

    public List<User> selectedQueryUser(String id, String name, String birthday) {
        List<User> list = new ArrayList<>();
        DbManager dbManager = new DbManager();
        try {
            StringBuilder sb = new StringBuilder();
            String s = "select * from user where 1=1";
            if (!id.equals("")) {
                sb.append(" and id like " + id);
            }
            if (!name.equals("")) {
                sb.append(" and username like '" + name + "'");
            }
            if (!birthday.equals("")) {
                sb.append(" and birthday like '" + birthday + "'");
            }
            String sql = s + sb;
            System.out.println(sql);
            ResultSet rs = dbManager.queryMethod(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setBirthday(rs.getString("birthday"));
                user.setSex(rs.getString("sex"));
                user.setAddress(rs.getString("address"));
                if (user != null) {
                    list.add(user);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbManager.closeDb();
        }
        return list;
    }

    public User findUserById(int id) {
        User user = new User();
        DbManager dbManager = new DbManager();
        try {
            String sql = "select * from user where id =" + id;
            ResultSet rs = dbManager.queryMethod(sql);
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setBirthday(rs.getString("birthday"));
                user.setSex(rs.getString("sex"));
                user.setAddress(rs.getString("address"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            dbManager.closeDb();
        }
        return user;
    }
}
