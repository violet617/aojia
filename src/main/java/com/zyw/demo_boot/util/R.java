package com.zyw.demo_boot.util;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String ,Object> {
    public R() {
        put("code",200);
        put("msg","success");
    }
    //错误的响应
    public static  R error (int code,String msg){
        R r=new R();
        r.put("code",code);
        r.put("msg",msg);
        return r;
    }
    public static  R error (String msg){
        return error(500,msg);
    }
    public static  R error (){
        return error(500,"服务器异常");
    }

    //成功的响应
    public static R ok(String msg){
        R r = new R();
        r.put("msg",msg);
        return r;
    }
    public static R ok(){
        return new R();
    }
    public static R ok(Map<String,Object> map){
        R r = new R();
        r.putAll(map);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
