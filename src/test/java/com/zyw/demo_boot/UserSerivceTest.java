package com.zyw.demo_boot;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyw.demo_boot.pojo.Users;
import com.zyw.demo_boot.service.UsersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSerivceTest {

    //将UsersServiceImpl对象交给service
    @Autowired
    UsersService service;

    @Test
    void test(){
        //注册测试
        System.out.println(service.regist(
            new Users(0,"wyf12138","123","1",null,null)
        ));

//        //登录测试
//        Users user=new Users();
//        user.setUsername("wyf12138");
//        user.setPassword("123");
//        System.out.println(service.login(user));

//        //获得所有用户测试
//        IPage<Users> page=service.findAll(1,4);
//        page.getRecords().forEach(System.out ::println);

//        //删除测试
//        service.delete(13);

//        //模糊查询测试
//        service.findByUsername("w",1,5).getRecords().forEach(System.out ::println);

    }
}
