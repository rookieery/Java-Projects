package pers.Lu.sms.service;

import pers.Lu.sms.bean.LoginForm;
import pers.Lu.sms.bean.Teacher;

import java.util.List;


public interface TeacherService {


    Teacher login(LoginForm loginForm);


    List<Teacher> selectList(Teacher teacher);


    Teacher findByTno(Teacher teacher);


    int insert(Teacher teacher);


    int update(Teacher teacher);


    int deleteById(Integer[] ids);


    int updatePassowrd(Teacher teacher);

}
