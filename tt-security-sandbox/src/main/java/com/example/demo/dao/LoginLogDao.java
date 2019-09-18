package com.example.demo.dao;

import com.example.demo.domain.bo.LoginLog;

import java.util.List;

public interface LoginLogDao {
    /**
     * 新增登录日志
     *
     * @param loginLog
     * @return
     */
    LoginLog save(LoginLog loginLog);

    /**
     * 查询用户的所有登录日志
     *
     * @param userId
     * @return
     */
    List<LoginLog> findByUserId(Integer userId);
}
