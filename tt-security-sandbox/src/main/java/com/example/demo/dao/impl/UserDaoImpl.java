package com.example.demo.dao.impl;

import com.example.demo.dao.PasswordDao;
import com.example.demo.dao.StrategyDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.Password;
import com.example.demo.domain.Strategy;
import com.example.demo.domain.User;
import com.example.demo.domain.UserDo;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user,userDo);
        UserDo save = userMapper.save(userDo);
        BeanUtils.copyProperties(save, user);
        user.setStrategies(user.getStrategies().parallelStream().map(strategy -> strategyDao.saveStrategy(strategy)).collect(Collectors.toList()));
        user.setPasswords(user.getPasswords().parallelStream().map(password -> passwordDao.savePassword(password)).collect(Collectors.toList()));
        return user;
    }
}
