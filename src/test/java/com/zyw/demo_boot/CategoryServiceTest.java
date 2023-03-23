package com.zyw.demo_boot;

import com.zyw.demo_boot.pojo.Category;
import com.zyw.demo_boot.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    CategoryService service;

    @Test
    void test(){
        // //添加测试
        // System.out.println(service.add("c1"));

//        //列出所有测试
//        service.findAll(false).forEach(System.out ::println);

//        // 删除测试
//        System.out.println(service.delete(40));

        //更新测试

        /*Category c=new Category();
        c.setId(7);
        c.setName("c100");
        System.out.println(service.update(c));*/

        /*Category c=new Category();
        c.setId(7);
        c.setName("新鲜水果");
        System.out.println(service.update(c));*/

        Category c=new Category();
        c.setId(7);
        c.setStatus(1);
        System.out.println(service.update(c));


    }
}
