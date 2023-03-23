package com.zyw.demo_boot;


import com.zyw.demo_boot.dao.UsersMapper;
import com.zyw.demo_boot.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoBootApplicationTests {

    @Autowired
    UsersMapper mapper;

    @Test
    void test(){
        List<Users> users=mapper.selectList(null);
        users.forEach(System.out ::println);
    }
}
