package com.lu.model;

import com.lu.dao.AddUserDao;
import com.lu.dao.DelUserDao;
import com.lu.dao.QueryUserDao;
import com.lu.dao.UpdateUserDao;
import com.lu.vo.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private QueryUserDao queryUserDao = new QueryUserDao();
    private AddUserDao addUserDao = new AddUserDao();
    private DelUserDao delUserDao = new DelUserDao();
    private UpdateUserDao updateUserDao = new UpdateUserDao();
    @Override
    public List<User> queryUser() {
        return queryUserDao.queryUser();
    }

    @Override
    public void addUser(User user) {
        addUserDao.addUser(user);
    }

    @Override
    public void delUser(int id) {
        delUserDao.delUser(id);
    }

    @Override
    public User findUserById(String id) {
        return queryUserDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        updateUserDao.updateUser(user);
    }
}
