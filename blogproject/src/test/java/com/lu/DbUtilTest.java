package com.lu;

import com.lu.tools.DbUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DbUtilTest {
    @Test
    public void test1() {
        Connection connection = DbUtil.getConnection();
        //System.out.println(connection);
        Assert.assertNotNull(connection);
    }
}
