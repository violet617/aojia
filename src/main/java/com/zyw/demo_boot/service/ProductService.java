package com.zyw.demo_boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyw.demo_boot.pojo.Product;

import java.util.List;

public interface ProductService {
    //添加商品
    boolean add(Product p);

    //id查询商品
    Product findById(Integer id);
    //修改商品
    boolean update(Product p);

    /**
     * 获取商品列表
     * @param name 按名称模糊查询
     * @param status 按状态查询
     * @param pageNo 页码
     * @param size 显示数量
     * @return 分页对象
     */
    IPage<Product> findAll(String name,Integer status,Integer pageNo,Integer size);

    //按分类获取商品列表
    List<Product> findByCategory(Integer cid);

}
