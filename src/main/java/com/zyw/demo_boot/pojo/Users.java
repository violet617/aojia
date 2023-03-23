package com.zyw.demo_boot.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok插件简化实体类
@Data //get set toString()
@AllArgsConstructor //有参构造
@NoArgsConstructor //无参构造

public class Users {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String a;
    private String b;

}
