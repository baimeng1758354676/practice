package com.example.demo.service.Impl;

import com.example.demo.dao.StrategyDao;
import com.example.demo.dao.UserDao;
import com.example.demo.mapper.*;
import com.example.demo.domain.*;
import com.example.demo.service.UserService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;


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

    @Autowired
    StrategyDao strategyDao;

    @Override
    public User checkUserName(String name) {
        return userDao.findByUserName(name);
    }

    @Override
    public User register(User user) {
        //注册时用户关联的策略为默认策略
        ArrayList<Strategy> strategies = new ArrayList<>();
        strategies.add(strategyDao.findByName(Constant.STRATEGY_DEFAULT_NAME));
        user.setStrategies(strategies);
        return userDao.save(user);
    }

    @Override
    public User login(User user) {
        User userInfo = userDao.findByUserName(user.getUserName());
        if (!ObjectUtils.isEmpty(userInfo)) {
            return userInfo.getPassword().equals(user.getPassword()) ? userInfo : null;
        }
        return null;
    }

    @Override
    public User configureStrategy(User user) {
        return userDao.save(user);
    }
}
