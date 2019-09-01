package pers.Lu.sms.dao;

import pers.Lu.sms.bean.Admin;
import pers.Lu.sms.bean.LoginForm;

import java.util.List;

public interface AdminMapper {


    Admin login(LoginForm loginForm);


    Admin findByName(String name);


    int insert(Admin admin);


    List<Admin> selectList(Admin admin);


    int update(Admin admin);


    int updatePassword(Admin admin);


    int deleteById(Integer[] ids);

}