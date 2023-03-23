package com.zyw.demo_boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyw.demo_boot.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ProductMapper extends BaseMapper<Product> {
}
