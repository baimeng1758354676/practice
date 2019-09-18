package com.example.demo.controller;

import com.example.demo.domain.LoginLog;
import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 标记下次修改密码
     * @param user
     * @return
     */
    public User signNextChangePassword(@RequestBody User user) {
        return userService.signNextChangePassword(user);
    }

    /**
     * 删除用户（逻辑删除，更新账号状态）
     * @param user
     * @return
     */
    @PostMapping(value = "/deleteUser")
    public User c(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    /**
     * 批量删除用户
     * @param users
     * @return
     */
    @PostMapping(value = "/batchDeleteUser")
    public List<User> batchDeleteUser(@RequestBody List<User> users) {
        return userService.batchDeleteUser(users);
    }

    /**
     * 配置密码策略
     * @param user
     * @return
     */
    @PostMapping(value = "/configureStrategy")
    public User configureStrategy(@RequestBody User user) {
        return userService.configureStrategy(user);
    }

    /**
     * 批量配置密码策略
     * @param users
     * @return
     */
    @PostMapping(value = "/batchConfigureStrategy")
    public List<User> batchConfigureStrategy(@RequestBody List<User> users) {
        return userService.batchConfigureStrategy(users);
    }


    /**
     * 查询登录日志
     * @param user
     * @return
     */
    @PostMapping(value = "/findLoginLogByUserId")
    public List<LoginLog> findLoginLogByUserId(@RequestBody User user) {
        return userService.findLoginLogByUserId(user);
    }


    /**
     * 用户分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/pageUser")
    public Page<User> pageUser(@RequestParam(value = "pageNum") Integer pageNum,
                               @RequestParam(value = "pageSize") Integer pageSize) {
        return userService.pageUser(pageNum, pageSize);
    }
}
