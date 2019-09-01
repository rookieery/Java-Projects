package com.lu.dao;

import com.lu.tools.DbManager;
import com.lu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Component
public class QueryUserDao {
    @Autowired
    private DbManager dbManager;

    public List<User> queryUser() {
        List<User> list = new ArrayList<>();
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
//        User user = new User();
//        user.setId(2);
//        user.setUsername("海洋");
//        user.setBirthday("2000-09-08");
//        user.setSex("女");
//        user.setAddress("西安");
//        list.add(user);
        return list;
    }
}
