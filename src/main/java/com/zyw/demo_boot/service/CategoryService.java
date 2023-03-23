package com.zyw.demo_boot.service;

import com.zyw.demo_boot.pojo.Category;

import java.util.List;

public interface CategoryService {

    //添加
    boolean add(String name);
    //获得所有，true所有，false 6条
    List<Category> findAll(Boolean isAll);
    //删除
    boolean delete(Integer id);
    //更新
    boolean update(Category c);


}
