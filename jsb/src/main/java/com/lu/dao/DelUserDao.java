package com.lu.dao;

import com.lu.tools.DbManager;

public class DelUserDao {

    public void delUser(int id) {
        DbManager dbManager = new DbManager();
        String sql = "delete from user where id = " + id;
        dbManager.nonQueryMethod(sql);
        dbManager.closeDb();
    }
}
