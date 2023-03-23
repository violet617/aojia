package com.zyw.demo_boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyw.demo_boot.dao.CategoryMappper;
import com.zyw.demo_boot.pojo.Category;
import com.zyw.demo_boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpi implements CategoryService {
    @Autowired
    private CategoryMappper categoryMappper;

    @Override
    public boolean add(String name) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        Category dbCategory = categoryMappper.selectOne(wrapper.eq("name", name));
        if (dbCategory == null) {
            categoryMappper.insert(new Category(0, name, 1, new Timestamp(new Date().getTime()), null, null));
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findAll(Boolean isAll) {
        List<Category> categories = null;
        if (isAll) {
            categories = categoryMappper.selectList(null);
        } else {
            QueryWrapper<Category> wrapper = new QueryWrapper<>();
            categories = categoryMappper.selectList(wrapper.eq("status", 1).last("limit 0,6"));
        }
        return categories;
    }

    @Override
    public boolean delete(Integer id) {
        //忽略，选查询该分类下是否有商品
        categoryMappper.deleteById(id);
        return true;
    }

    @Override
    public boolean update(Category c) {
        //分类的修改，修改名称，修改状态
        Category dbCategory = categoryMappper.selectById(c.getId());
        if (c.getName() != null) {//修改名称
            //如果该名称存在，不能修改，selectCount（）查询条数
            if (categoryMappper.selectCount(new QueryWrapper<Category>().eq("name", c.getName())) > 0) {
                return false;
            }
            dbCategory.setName(c.getName());
        } else if (c.getStatus() != null) {//修改状态（1，-1）
            //c.getStatus()传入的是分类当前状态
            dbCategory.setStatus(-c.getStatus());
        }
        categoryMappper.updateById(dbCategory);
        return true;
    }

}