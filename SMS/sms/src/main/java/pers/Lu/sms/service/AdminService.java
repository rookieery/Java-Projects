package pers.Lu.sms.service;

import pers.Lu.sms.bean.Admin;
import pers.Lu.sms.bean.LoginForm;

import java.util.List;

public interface AdminService {


    Admin login(LoginForm loginForm);


    Admin findByName(String name);


    int insert(Admin admin);


    List<Admin> selectList(Admin admin);


    int update(Admin admin);


    int updatePassowrd(Admin admin);


    int deleteById(Integer[] ids);

}