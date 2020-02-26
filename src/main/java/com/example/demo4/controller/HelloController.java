package com.example.demo4.controller;

import com.example.demo4.dto.HelloDto;
import com.example.demo4.dto.User;
import com.example.demo4.service.HelloService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//返回json格式数据
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
public class HelloController {
    @Resource
    private HelloService helloServic;


//    @RequestMapping("/hello")
//    public String hello() {
//        return "hello,this is a springboot demo !";
//    }
    @RequestMapping("/getJson")
    @ResponseBody
    public User getJson() {
        User user = new User();
        user.setAge(10);
        user.setId("1asdasd");
        user.setName("bobo");
        return user;
    }
    @RequestMapping("/testSql")
    @ResponseBody
    public List<HelloDto> testSql(){
        System.err.println("controller");
        return helloServic.getCramping();
    }
}

