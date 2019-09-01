package pers.Lu.sms.service;

import pers.Lu.sms.bean.LoginForm;
import pers.Lu.sms.bean.Student;

import java.util.List;


public interface StudentService {


    Student login(LoginForm loginForm);


    List<Student> selectList(Student student);


    Student fingBySno(Student student);


    int insert(Student student);


    int update(Student student);


    int updatePassowrd(Student student);


    int deleteById(Integer[] ids);

}

