package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户名校验
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/checkUserName")
    public User checkUserName(@RequestParam(value = "name") String name) {
        return userService.checkUserName(name);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */

    @PostMapping(value = "/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }


    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    public User login(@RequestBody User user) {
        return userService.login(user);
    }

    /**
     * 配置密码策略
     * @param user
     * @return
     */
    public User configureStrategy(@RequestBody User user) {
        return userService.configureStrategy(user);
    }



}
