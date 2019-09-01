package com.lu;

import com.lu.model.USerServiceImpl;
import com.lu.model.UserService;
import com.lu.vo.User;
import org.junit.Assert;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1() {
        UserService userService = new USerServiceImpl();
        Assert.assertNotNull(userService);
    }
}
