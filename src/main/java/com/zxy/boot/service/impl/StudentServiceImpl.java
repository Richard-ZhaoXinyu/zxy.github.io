package com.zxy.boot.service.impl;

import com.zxy.boot.bean.Student;
import com.zxy.boot.mapper.StudentMybatisDao;
import com.zxy.boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author Richard
 * @date Created on 2022/2/25
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMybatisDao studentMybatisDao;

    @Override
    public Student getStuById(Integer id) {

        return studentMybatisDao.getStudent(id);
    }

    @Override
    public int addStudent(Student student) {
        return studentMybatisDao.addStudent(student);
    }
}
