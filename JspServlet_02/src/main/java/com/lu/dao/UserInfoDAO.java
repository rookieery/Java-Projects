package com.lu.dao;

import com.lu.tools.DbManager;
import com.lu.vo.UserInfo;

import java.sql.ResultSet;

public class UserInfoDAO {
    public int checkUserInfo(UserInfo userInfo){
        int flag = 0;
        String strSql = "select t_username,t_userpass from t_user where t_username='"+userInfo.getUserName()+"' and t_userpass='"+userInfo.getUserPass()+"'";
        try {
            DbManager dbManager = new DbManager();
            ResultSet rs = dbManager.queryMethod(strSql);
            String username = null;
            String password = null;
            while (rs.next()) {
                username = rs.getString("t_username");
                password = rs.getString("t_userpass");
                if (username.equals(userInfo.getUserName()) && password.equals(userInfo.getUserPass())) {
                    flag = 1;
                    return flag;
                } else {
                    flag = 0;
                    return flag;
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return flag;
    }
}
