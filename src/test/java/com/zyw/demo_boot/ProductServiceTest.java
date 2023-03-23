package com.zyw.demo_boot;

import com.zyw.demo_boot.pojo.Product;
import com.zyw.demo_boot.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    ProductService service;
    @Test
    void test(){
        /*//添加测试
        Product p=new Product();
        p.setCid(1);
        p.setName("小米18");
        p.setDetail("x");
        p.setImgpath("y");
        p.setPrice(11.22);
        System.out.println(service.add(p));*/

        /*//查找测试
        System.out.println(service.findById(1));*/

        /*//按id更新测试
        Product p=new Product();
        p.setCid(2);
        p.setName("小米8p");
        p.setDetail("x1");
        p.setImgpath("y1");
        p.setPrice(99.99);
        p.setId(6);
        System.out.println(service.update(p));*/

        //只查在售，下架
        //service.findAll(null,null,1,5).getRecords().forEach(System.out ::println);
        //按名称模糊查询，在售，下架
        //service.findAll("小米",null,1,5).getRecords().forEach(System.out ::println);
        //按名称模糊查询，指定状态
        //service.findAll("小米",3,1,5).getRecords().forEach(System.out ::println);

        //按分类查询
        service.findByCategory(1).forEach(System.out ::println);
    }
}
