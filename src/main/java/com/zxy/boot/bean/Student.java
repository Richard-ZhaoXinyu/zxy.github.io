package com.zxy.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Description:
 *
 * @author Richard
 * @date Created on 2022/2/25
 */

@AllArgsConstructor
@ToString
@Data
public class Student {

    private Integer id;
    private String userName;
    private String email;
    private Integer age;

    public Student() {
    }

}
