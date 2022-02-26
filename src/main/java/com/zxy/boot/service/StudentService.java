package com.zxy.boot.service;

import com.zxy.boot.bean.Student;

/**
 * Description:
 *
 * @author Richard
 * @date Created on 2022/2/25
 */
public interface StudentService {

    Student getStuById(Integer id);

    int addStudent(Student student);
}
