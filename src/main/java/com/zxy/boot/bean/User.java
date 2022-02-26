package com.zxy.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * Description:
 *
 * @author Richard
 * @date Created on 2022/2/24
 */

@Data
public class User {

    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;

    //以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
