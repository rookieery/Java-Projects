package com.lu.model;

import com.lu.vo.User;

import java.util.List;

public interface UserService {
    public List<User> queryUser();

    void addUser(User user);

    void delUser(int id);

    User findUserById(String id);

    void updateUser(User user);
}
