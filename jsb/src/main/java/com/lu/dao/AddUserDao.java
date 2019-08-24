package com.lu.dao;

import com.lu.tools.DbManager;
import com.lu.vo.User;

public class AddUserDao {

    public void addUser(User user) {
        DbManager dbManager = new DbManager();
        String sql = "insert into user values(" + user.getId() +",'"+user.getUsername()+"','"+
                user.getBirthday()+"','"+ user.getSex()+"','"+user.getAddress()+"')";
        dbManager.nonQueryMethod(sql);
        dbManager.closeDb();
    }
}
