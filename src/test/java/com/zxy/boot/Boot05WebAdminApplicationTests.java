package com.zxy.boot;

import com.zxy.boot.bean.User;
import com.zxy.boot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_bank", Long.class);
        log.info("总记录数："+aLong);
    }


    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1);
        log.info("用户信息：{}",user);
    }
}
