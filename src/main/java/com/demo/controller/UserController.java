package com.demo.controller;

import com.demo.bean.UserBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @RequestMapping("/user")
    public @ResponseBody UserBean getUserInfo(){
        UserBean user = new UserBean();
        user.setId(1);
        user.setName("dawei");
        user.setAge(18);
        user.setSex("男");
        user.setEmail("11@qq.com");
        return user;
    }
}
