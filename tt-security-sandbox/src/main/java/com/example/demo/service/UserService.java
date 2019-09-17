package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.UserDo;
import com.example.demo.domain.UserVo;
import com.example.demo.dto.UserDto;

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
     * @param userVo
     * @return
     */
    User login(UserVo userVo);
}
