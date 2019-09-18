package com.example.demo.dao.impl;

import com.example.demo.dao.PasswordDao;
import com.example.demo.dao.StrategyDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.*;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserStrategyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    PasswordDao passwordDao;

    @Autowired
    StrategyDao strategyDao;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserStrategyMapper userStrategyMapper;

    @Override
    public User findById(Integer id) {
        UserDo userDo = userMapper.findFirstById(id);
        List<Password> passwords = passwordDao.findByUserId(id);
        List<Strategy> strategies = strategyDao.findByUserId(id);
        User user = new User();
        user.setStrategies(strategies);
        user.setPasswords(passwords);
        BeanUtils.copyProperties(userDo,user);
        return user;
    }

    @Override
    public User findByUserName(String userName) {
       return findById(userMapper.findFirstByUserName(userName).getId());
    }

    @Override
    public User save(User user) {
        //修改基本信息
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user,userDo);
        userMapper.save(userDo);
        BeanUtils.copyProperties(userDo, user);
        //修改/配置用户对应的策略
        if (!ObjectUtils.isEmpty(user.getStrategies())) {
            List<Strategy> strategies = user.getStrategies();
            strategies.parallelStream().forEach(strategy -> strategyDao.saveStrategy(strategy));
            strategies.parallelStream().forEach(strategy -> userStrategyMapper.save(new UserStrategyDo(strategy.getId(),user.getId())));
        }
        //修改用户对应的密码
        if (!ObjectUtils.isEmpty(user.getPasswords())) {
           user.getPasswords().parallelStream().forEach(password -> passwordDao.savePassword(password));
        }
        return user;
    }
}
