package com.zyw.demo_boot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyw.demo_boot.dao.UsersMapper;
import com.zyw.demo_boot.pojo.Users;
import com.zyw.demo_boot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UsersServiceImpi implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public boolean regist(Users user) {
        //查询条件
        QueryWrapper<Users> wrapper=new QueryWrapper<>();
        //查询一条用户信息selectOne，wrapper.eq（）按用户名查询
        Users dbUser=usersMapper.selectOne(wrapper.eq("username",user.getUsername()));

        //查询dbUser是空表示没有该用户，就可以注册了
        if(dbUser==null){
            String md5Pwd= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(md5Pwd);
            //执行添加参数user，你看到的insert（） selectOne（）都是接口BaseMapper提供的
            usersMapper.insert(user);
            return true;
        }
        return false;
    }

    @Override
    public Users login(Users user) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        Users dbUser=usersMapper.selectOne(wrapper.eq("username",user.getUsername()));
        //用户查到了，并且密码是对的，表示登录成功了
        if(dbUser != null && dbUser.getPassword().equals(
                 DigestUtils.md5DigestAsHex(user.getPassword().getBytes()))){
            dbUser.setPassword("");
            return dbUser;
        }
        return null;
    }

    @Override
    public IPage<Users> findAll(int pageNo, int size) {
        IPage<Users> page=new Page<>(pageNo,size);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        //selectPage（分页条件，查询条件）；
        //ne（）不等于，orderByDesc倒序
        //page对象是一页的结果，包含分页的相关信息
        page= usersMapper.selectPage(page,wrapper.ne("username","admin").orderByDesc("id"));
        //清空所有的用户的密码
        page.getRecords().forEach(u-> u.setPassword(""));
        return page;
    }

    @Override
    public void delete(Integer id) {
        usersMapper.deleteById(id);

    }

    @Override
    public IPage<Users> findByUsername(String username, int pageNo, int size) {
        IPage<Users> page = new Page<>(pageNo, size);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        //like模糊查询
        page=usersMapper.selectPage(page,wrapper
                .like("username",username)
                .ne("username","admin")
                .orderByDesc("id"));
        page.getRecords().forEach(u->u.setPassword(""));
        return page;
    }
}
