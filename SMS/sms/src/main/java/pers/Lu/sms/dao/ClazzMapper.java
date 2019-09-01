package pers.Lu.sms.dao;

import pers.Lu.sms.bean.Clazz;

import java.util.List;


public interface ClazzMapper {


    List<Clazz> selectList(Clazz clazz);


    List<Clazz> selectAll();


    Clazz findByName(String name);


    int insert(Clazz clazz);


    int deleteById(Integer[] ids);


    int update(Clazz clazz);

}
