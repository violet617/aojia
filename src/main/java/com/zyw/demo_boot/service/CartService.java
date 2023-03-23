package com.zyw.demo_boot.service;

import com.zyw.demo_boot.pojo.Cart;

import java.util.List;

public interface CartService {
    //用户id获得购物车数量
    Integer findCount(Integer uid);

    //用户id获得购物车列表
    List<Cart> findAll(Integer uid);

    //id选中修改
    void updateChecked(Integer id);

    //id修改数量，true加，false减
    void updateQuantity(Integer id,boolean isAdd);

    //删除
    void delete(Integer id);

    //添加
    void add(Cart c);
}
