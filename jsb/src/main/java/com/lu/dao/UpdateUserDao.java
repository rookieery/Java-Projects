package com.lu.dao;

import com.lu.tools.DbManager;
import com.lu.vo.User;

public class UpdateUserDao {
    public void updateUser(User user) {
        DbManager dbManager = new DbManager();
        String sql = "update user set username='" + user.getUsername() + "',birthday='" +
                user.getBirthday() + "',sex='" + user.getSex() + "',address='" + user.getAddress() +
                "' where id = " + user.getId();
        dbManager.nonQueryMethod(sql);
        dbManager.closeDb();
    }
}
