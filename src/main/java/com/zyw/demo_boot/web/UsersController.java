package com.zyw.demo_boot.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zyw.demo_boot.pojo.Users;
import com.zyw.demo_boot.service.UsersService;
import com.zyw.demo_boot.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //当前类是控制器，他响应json
//该控制器访问路径 http://localhost:8001/users
@RequestMapping("/users")
public class UsersController {

    //注入users的业务对象
    @Autowired
    private UsersService usersService;

    //z注册
    @PostMapping("/regist")
    public R regist(Users user){
        if(usersService.regist(user)){
            return R.ok();
        }
        return R.error("用户已存在");
    }

    //登录
    @PostMapping("/login")
    public R login(Users user){
        Users dbUsers = usersService.login(user);
        if(dbUsers != null){
             return R.ok().put("user",dbUsers);
        }
        return R.error("用户名或者密码错误");
    }

    //删除
    @RequestMapping("/delete/{id}")
    public R delete(@PathVariable("id") Integer id){
        usersService.delete(id);
        return R.ok();
    }
    //查询所有
    @RequestMapping("/list/{pageNo}/{size}")
    public R list(@PathVariable("pageNo") Integer pageNo, @PathVariable("size") Integer size){
        IPage<Users> page = usersService.findAll(pageNo, size);
        //pages总页数
        return R.ok().put("pages",page.getPages()).put("users",page.getRecords());
    }
    //用户名模糊查询
    @RequestMapping("/byName/{pageNo}/{size}")
    public R byName(String username,@PathVariable("pageNo") Integer pageNo,@PathVariable("size") Integer size){
        IPage<Users> page = usersService.findByUsername(username, pageNo, size);
        return R.ok().put("pages",page.getPages()).put("users",page.getRecords());
    }
}
