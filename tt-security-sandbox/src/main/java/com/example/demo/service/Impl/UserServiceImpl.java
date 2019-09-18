package com.example.demo.service.Impl;

import com.example.demo.dao.LoginLogDao;
import com.example.demo.dao.StrategyDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.*;
import com.example.demo.service.UserService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    StrategyDao strategyDao;

    @Autowired
    LoginLogDao loginLogDao;


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
            if (userInfo.getPassword().equals(user.getPassword())) {
                //登录成功，新增登录日志
                LoginLog loginLog = new LoginLog();
                loginLog.setUserId(userInfo.getId());
                loginLog.setLoginTime(LocalDateTime.now());
//                loginLog.setLoginPlace();
                loginLogDao.save(loginLog);
                return userInfo;
            }
        }
        return null;
    }

    @Override
    public User configureStrategy(User user) {
        return userDao.save(user);
    }

    @Override
    public List<LoginLog> findLoginLogByUserId(User user) {
        return loginLogDao.findByUserId(user.getId());
    }

    @Override
    public User signNextChangePassword(User user) {
        return userDao.save(user);
    }

    @Override
    public Page<User> pageUser(Integer pageNum, Integer pageSize) {
        return userDao.pageUser(pageNum,pageSize);
    }

    @Override
    public User deleteUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> batchDeleteUser(List<User> users) {
        ArrayList<User> userList = new ArrayList<>();
        users.parallelStream().forEach(user -> {
            userList.add(deleteUser(user));
        });
        return userList;
    }

    @Override
    public List<User> batchConfigureStrategy(List<User> users) {
        ArrayList<User> userList = new ArrayList<>();
        users.parallelStream().forEach(user -> {
            userList.add(configureStrategy(user));
        });
        return null;
    }
}
