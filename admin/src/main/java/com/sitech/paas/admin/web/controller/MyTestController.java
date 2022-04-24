package com.sitech.paas.admin.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 测试controller
 * @author huangzb
 * @date 2022/4/24
 */
@RestController
@RequestMapping("test")
public class MyTestController {

    @RequestMapping("hello")
    public String testMethod(){
        return "Hello World!";
    }

    @RequestMapping("exception")
    public int getException(){
        HashMap<String, Integer> map = new HashMap<>(8);
        map.put("1",1);
        map.put("2",0);
        return map.get("1")/map.get("2");
    }

    @RequestMapping("myException")
    public int myException(){
        int  i;
        try {
            HashMap<String, Integer> map = new HashMap<>(8);
            map.put("1",1);
            map.put("2",0);
            i = map.get("1")/map.get("2");
        }catch (Exception e){
            throw new RuntimeException("除数为0了!");
        }
        return i;
    }

}
