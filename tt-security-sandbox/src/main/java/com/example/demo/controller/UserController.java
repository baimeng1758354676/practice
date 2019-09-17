package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.domain.UserDo;
import com.example.demo.domain.UserVo;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户名校验
     * @param name
     * @return
     */
    @GetMapping(value = "/checkUserName")
    public User checkUserName(@RequestParam(value = "name") String name) {
        return userService.checkUserName(name);
    }

    /**
     * 注册
     * @param user
     * @return
     */

    @PostMapping(value = "/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }


    /**
     * 登录
     * @param userVo
     * @return
     */
    @PostMapping(value = "/login")
    public User login(@RequestBody UserVo userVo) {
        return userService.login(userVo);
    }

}
