package com.zyw.demo_boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyw.demo_boot.pojo.Users;
//用户业务接口
public interface UsersService {
    //注册
    boolean regist(Users user);
    //登录
    Users login(Users user);
    //获得所有用户
    IPage<Users> findAll(int pageNo, int size);
    //删除
    void delete(Integer id);
    //按用户名模糊查询,传入用户名，
    IPage<Users> findByUsername(String username,int pageNo,int size);

}
