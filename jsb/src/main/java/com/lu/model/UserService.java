package com.lu.model;

import com.lu.vo.User;
import com.lu.vo.UserCustom;
import com.lu.vo.UserVo;

import java.util.List;

public interface UserService {
    public List<User> queryUser();

    void addUser(User user);

    void delUser(int id);

    User findUserById(String id);

    void updateUser(User user);

    void delPartUser(String[] ids);

    List<User> selectedQueryUser(String id,String name,String birthday);
}
