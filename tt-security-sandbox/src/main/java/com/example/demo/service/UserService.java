package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
    /**
     * 用户名校验
     * @param name
     * @return
     */
    User checkUserName(String name);

    /**
     * 注册
     * @param user
     * @return
     */
    User register(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 配置密码策略
     * @param user
     * @return
     */
    User configureStrategy(User user);
}
