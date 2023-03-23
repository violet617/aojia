package com.zyw.demo_boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyw.demo_boot.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CategoryMappper extends BaseMapper<Category> {
}
