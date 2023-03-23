package com.zyw.demo_boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyw.demo_boot.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

//用户数据访问接口,BaseMapper提供了基础访问功能
@Mapper
@Component
public interface UsersMapper extends BaseMapper<Users> {

}
