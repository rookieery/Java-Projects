package pers.Lu.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.Lu.sms.bean.Grade;
import pers.Lu.sms.dao.GradeMapper;
import pers.Lu.sms.service.GradeService;

import java.util.List;


@Service
@Transactional
public class GradeServiceImpl implements GradeService {

    //注入Mapper接口对象
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> selectList(Grade gradename) {
        return gradeMapper.selectList(gradename);
    }

    @Override
    public List<Grade> selectAll() {
        return gradeMapper.selectAll();
    }

    @Override
    public Grade findByName(String gradename) {
        return gradeMapper.findByName(gradename);
    }

    @Override
    public int insert(Grade grade) {
        return gradeMapper.insert(grade);
    }

    @Override
    public int update(Grade grade) {
        return gradeMapper.update(grade);
    }

    @Override
    public int deleteById(Integer[] ids) {
        return gradeMapper.deleteById(ids);
    }
}