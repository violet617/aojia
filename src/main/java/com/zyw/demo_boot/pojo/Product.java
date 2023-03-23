package com.zyw.demo_boot.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private Integer cid;
    private String name;
    private String detail;
    private String imgpath;
    private Double price;
    //1在售2下架3删除
    private Integer status;
    private String a;
    private String b;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Timestamp createTime;
}
