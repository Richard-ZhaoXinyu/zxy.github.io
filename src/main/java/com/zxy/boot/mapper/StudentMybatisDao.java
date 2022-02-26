package com.zxy.boot.mapper;

import com.zxy.boot.bean.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @author Richard
 * @date Created on 2022/2/25
 */

@Mapper
public interface StudentMybatisDao {

    Student getStudent(Integer id);

    @Insert("insert into student values(#{id},#{userName},#{email},#{age})")
    int addStudent(Student student);
}
