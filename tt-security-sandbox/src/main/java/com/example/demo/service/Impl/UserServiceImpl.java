package com.example.demo.service.Impl;

import com.example.demo.dao.UserDao;
import com.example.demo.mapper.*;
import com.example.demo.domain.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserStrategyMapper userStrategyMapper;

    @Autowired
    StrategyMapper strategyMapper;

    @Autowired
    StrategyRuleMapper strategyRuleMapper;

    @Autowired
    RuleMapper ruleMapper;

    @Autowired
    UserDao userDao;

    @Override
    public User checkUserName(String name) {
        return userDao.findByUserName(name);
    }

    @Override
    public User register(User user) {
        return userDao.save(user);
    }

    @Override
    public User login(UserVo userVo) {
        return userDao.findByUserName(userVo.getUserName());
    }
}
