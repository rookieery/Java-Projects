package pers.Lu.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.Lu.sms.bean.LoginForm;
import pers.Lu.sms.bean.Teacher;
import pers.Lu.sms.dao.TeacherMapper;
import pers.Lu.sms.service.TeacherService;

import java.util.List;


@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    //注入Mapper接口对象
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher login(LoginForm loginForm) {
        return teacherMapper.login(loginForm);
    }

    @Override
    public List<Teacher> selectList(Teacher teacher) {
        return teacherMapper.selectList(teacher);
    }

    @Override
    public Teacher findByTno(Teacher teacher) {
        return teacherMapper.findByTno(teacher);
    }

    @Override
    public int insert(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public int updatePassowrd(Teacher teacher) {
        return teacherMapper.updatePassword(teacher);
    }

    @Override
    public int deleteById(Integer[] ids) {
        return teacherMapper.deleteById(ids);
    }
}
