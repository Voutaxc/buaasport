package com.buaasport.competition.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    //构造函数私有化
    private R() {
    }

    public static R ok() {
        R r = new R();
        r.setCode(ResponseEnum.SUCCESS.getCode());
        r.setMessage(ResponseEnum.SUCCESS.getMessage());
        return r;
    }

    public static R error() {
        R r = new R();
        r.setCode(ResponseEnum.ERROR.getCode());
        r.setMessage(ResponseEnum.ERROR.getMessage());
        return r;
    }

    //设置特定的返回值
    public static R setResult(ResponseEnum responseEnum) {

        R r = new R();
        r.setCode(responseEnum.getCode());
        r.setMessage(responseEnum.getMessage());
        return r;

    }
//手动封装为map
    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
//直接传入map
    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

    public  R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }
}