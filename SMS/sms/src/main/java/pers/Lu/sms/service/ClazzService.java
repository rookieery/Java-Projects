package pers.Lu.sms.service;

import pers.Lu.sms.bean.Clazz;

import java.util.List;


public interface ClazzService {


    List<Clazz> selectList(Clazz clazz);


    List<Clazz> selectAll();


    int insert(Clazz clazz);


    int deleteById(Integer[] ids);


    Clazz findByName(String name);


    int update(Clazz clazz);

}
