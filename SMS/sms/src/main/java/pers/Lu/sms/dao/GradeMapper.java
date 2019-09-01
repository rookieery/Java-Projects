package pers.Lu.sms.dao;

import pers.Lu.sms.bean.Grade;

import java.util.List;


public interface GradeMapper {


    List<Grade> selectList(Grade gradename);


    List<Grade> selectAll();


    Grade findByName(String gradename);


    int insert(Grade grade);


    int update(Grade grade);


    int deleteById(Integer[] ids);
}
