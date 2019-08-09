package com.lu.model;

import com.lu.dao.UserInfoDAO;
import com.lu.vo.UserInfo;

public class UserInfoServiceImpl implements IUserInfoService {
    private UserInfoDAO userInfoDAO = new UserInfoDAO();
    @Override
    public int checkUserInfoService(UserInfo userInfo) {
        return userInfoDAO.checkUserInfo(userInfo);
    }
}
