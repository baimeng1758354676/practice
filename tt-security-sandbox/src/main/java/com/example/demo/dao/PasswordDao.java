package com.example.demo.dao;

import com.example.demo.domain.Password;
import com.example.demo.domain.PasswordDo;

import java.util.List;

/**
 * @author baimeng
 */
public interface PasswordDao {
    /**
     * 查询用户对应的密码集合
     * @param id 用户主键
     * @return
     */
    List<Password> findByUserId(Integer id);

    /**
     * 新增密码
     * @param password
     * @return
     */
    Password savePassword(Password password);
}
