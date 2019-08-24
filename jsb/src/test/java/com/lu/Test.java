package com.lu;

import com.lu.model.UserService;
import com.lu.model.UserServiceImpl;
import com.lu.tools.DbManager;
import com.lu.tools.JedisPoolUtils;
import com.lu.vo.User;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test1() {
        UserService queryUserService = new UserServiceImpl();
        List<User> list = queryUserService.queryUser();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void test2() {
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("hello", "wenhao");
        System.out.println(jedis.get("hello"));
        jedis.close();
    }

    @org.junit.Test
    public void test3() {
        DbManager dbManager = new DbManager();
        String sql = "insert into user values(99,'水','2000-09-07','男','西安')";
        dbManager.nonQueryMethod(sql);
    }
    @org.junit.Test
    public void test4() {
        DbManager dbManager = new DbManager();

    }
}
