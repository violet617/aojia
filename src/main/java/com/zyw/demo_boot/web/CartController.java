package com.zyw.demo_boot.web;

import com.zyw.demo_boot.pojo.Cart;
import com.zyw.demo_boot.service.CartService;
import com.zyw.demo_boot.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/findCount/{uid}")
    public R findCount(@PathVariable("uid") Integer uid){
        return R.ok().put("count",cartService.findCount(uid));
    }
    @RequestMapping("/list/{uid}")
    public R list(@PathVariable("uid") Integer uid){
        return R.ok().put("carts",cartService.findAll(uid));
    }
    @RequestMapping("/update_ck/{id}")
    public R update_ck(@PathVariable("id") Integer id){
        cartService.updateChecked(id);
        return R.ok();
    }
    @RequestMapping("/update_qu/{id}")
    public R update_qu(@PathVariable("id") Integer id,boolean isAdd){
        cartService.updateQuantity(id,isAdd);
        return R.ok();
    }
    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") Integer id){
        cartService.delete(id);
        return R.ok();
    }
    @RequestMapping("/add")
    public R add(Cart c){
        cartService.add(c);
        return R.ok();
    }

}
