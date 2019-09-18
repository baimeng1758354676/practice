package com.example.demo.service;

import com.example.demo.domain.bo.LoginLog;
import com.example.demo.domain.bo.Strategy;
import com.example.demo.domain.bo.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 用户名校验
     *
     * @param name
     * @return
     */
    User checkUserName(String name);

    /**
     * 注册
     *
     * @param user
     * @return
     */
    User register(User user);

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password) throws Exception;

    /**
     * 配置策略
     * @param userId
     * @param strategyId
     * @return
     */
    User configureStrategy(Integer userId, Integer strategyId);

    /**
     * 查询登录日志
     *
     * @param userId
     * @return
     */
    List<LoginLog> findLoginLogByUserId(Integer userId);

    /**
     * 标记下次登陆修改密码
     *
     * @param userId
     * @return
     */
    User signNextChangePassword(Integer userId);

    /**
     * 用户分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<User> pageUser(Integer pageNum, Integer pageSize);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    User deleteUser(Integer userId);

    /**
     * 批量删除用户
     * @param userIds
     * @return
     */
    List<User> batchDeleteUser(List<Integer> userIds);

    /**
     * 批量配置密码策略 userid 为 key strategyId 为 value
     * @param map
     * @return
     */
    List<User> batchConfigureStrategy(Map<Integer, Integer> map);
}
