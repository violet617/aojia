package com.zyw.demo_boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyw.demo_boot.dao.CartMapper;
import com.zyw.demo_boot.pojo.Cart;
import com.zyw.demo_boot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public Integer findCount(Integer uid) {
        return cartMapper.selectCount(new QueryWrapper<Cart>().eq("uid",uid));
    }

    @Override
    public List<Cart> findAll(Integer uid) {
        return cartMapper.selectList(new QueryWrapper<Cart>().eq("uid",uid).orderByDesc("create_time"));
    }

    @Override
    public void updateChecked(Integer id) {
        Cart c= cartMapper.selectById(id);
        c.setChecked(-c.getChecked());
        cartMapper.updateById(c);
    }

    @Override
    public void updateQuantity(Integer id, boolean isAdd) {
        Cart c = cartMapper.selectById(id);
        if(isAdd){
            c.setQuantity(c.getQuantity()+1);
        }else {
            c.setQuantity(c.getQuantity()-1);
        }
        cartMapper.updateById(c);
    }

    @Override
    public void delete(Integer id) {
        cartMapper.deleteById(id);
    }

    @Override
    public void add(Cart c) {
        QueryWrapper<Cart> wrapper = new QueryWrapper<>();
        Cart dbCart=cartMapper.selectOne(wrapper.eq("uid",c.getUid()).eq("pid",c.getPid()));
        if(dbCart!=null){
            dbCart.setQuantity(dbCart.getQuantity()+c.getQuantity());
            cartMapper.updateById(dbCart);
        }else {
            c.setChecked(1);
            c.setCreateTime(new Timestamp(new Date().getTime()));
            cartMapper.insert(c);
        }


    }
}
