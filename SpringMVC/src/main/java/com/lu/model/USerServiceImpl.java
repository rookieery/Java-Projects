package com.lu.model;

import com.lu.dao.QueryUserDao;
import com.lu.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class USerServiceImpl implements UserService {
    @Autowired
    private QueryUserDao queryUserDao;

    @Override
    public List<User> queryUser() {
        return queryUserDao.queryUser();
    }
}
