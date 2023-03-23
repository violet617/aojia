package com.zyw.demo_boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyw.demo_boot.dao.ProductMapper;
import com.zyw.demo_boot.pojo.Product;
import com.zyw.demo_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public boolean add(Product p) {
        Product dbProduct= productMapper.selectOne(new QueryWrapper<Product>().eq("name",p.getName()));
        if(dbProduct == null){
            p.setStatus(1);
            p.setCreateTime(new Timestamp(new Date().getTime()));
            productMapper.insert(p);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        return productMapper.selectById(id);
    }

    @Override
    public boolean update(Product p) {
        Product dbProduct=productMapper.selectOne(new QueryWrapper<Product>().eq("name",p.getName()));
        if (dbProduct == null) {
            return productMapper.updateById(p)>0;
        }
        return false;
    }

    @Override
    public IPage<Product> findAll(String name, Integer status, Integer pageNo, Integer size) {
        IPage<Product> page = new Page<>(pageNo,size);
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        if(name != null){
            wrapper.like("name",name);
        }
        //如果不指定状态，查在售和下架
        if(status == null){
            wrapper.in("status",1,2);
        }else {
            wrapper.eq("status",status);
        }
        return productMapper.selectPage(page,wrapper.orderByDesc("create_time"));
    }

    @Override
    public List<Product> findByCategory(Integer cid) {
        return productMapper.selectList(new QueryWrapper<Product>().eq("cid",cid).eq("status",1));
    }
}
