package com.zyw.demo_boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer id;
    private Integer uid;
    private Integer pid;
    private Integer quantity;
    private Integer checked;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Timestamp createTime;
    private String a;
    private String b;
}
