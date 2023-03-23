package com.zyw.demo_boot;

import com.zyw.demo_boot.pojo.Cart;
import com.zyw.demo_boot.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    CartService service;
    @Test
    public void test(){
        // System.out.println(service.findCount(3));

        // service.findAll(3).forEach(System.out ::println);

        // service.updateChecked(26);

         service.updateQuantity(31,true);

        //service.delete(26);

//        Cart c=new Cart();
//        c.setUid(4);
//        c.setPid(2);
//        c.setQuantity(2);
//        service.add(c);

    }

}
