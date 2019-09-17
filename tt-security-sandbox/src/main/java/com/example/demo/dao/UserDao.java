package com.example.demo.dao;

import com.example.demo.domain.User;

/**
 * @author baimeng
 */
public interface UserDao {
    /**
     * 主键查询用户具体信息（包括关联的策略，密码）
     * @param id 用户主键
     * @return
     */
    User findById(Integer id);

    /**
     *通过用户名查询用户所有信息（包括关联的策略，密码）
     * @param userName 用户名
     * @return
     */
    User findByUserName(String userName);

    /**
     * 新增/修改用户
     * @param user
     * @return
     */
    User save(User user);
}
