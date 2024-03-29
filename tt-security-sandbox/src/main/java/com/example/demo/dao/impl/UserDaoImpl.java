package com.example.demo.dao.impl;

import com.example.demo.dao.PasswordDao;
import com.example.demo.dao.StrategyDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.bo.Password;
import com.example.demo.domain.bo.Strategy;
import com.example.demo.domain.bo.User;
import com.example.demo.domain.dataobject.UserDo;
import com.example.demo.domain.dataobject.UserStrategyDo;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserStrategyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

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
        return findById(userMapper.findFirstById(id));
    }

    protected User findById(UserDo userDo) {
        User user = new User();
        if (!ObjectUtils.isEmpty(userDo)) {
            List<Strategy> strategies = strategyDao.findByUserId(userDo.getId());
            user.setStrategies(strategies);
            BeanUtils.copyProperties(userDo, user);
        }
        return user;
    }

    @Override
    public User findByUserName(String userName) {
        return findById(userMapper.findFirstByUserName(userName));
    }

    @Override
    public User save(User user) {
        //修改基本信息
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user, userDo);
        userMapper.save(userDo);
        BeanUtils.copyProperties(userDo, user);
        //修改/配置用户对应的策略
        if (!ObjectUtils.isEmpty(user.getStrategies())) {
            List<Strategy> strategies = user.getStrategies();
            strategies.parallelStream().forEach(strategy -> strategyDao.saveStrategy(strategy));
            strategies.parallelStream().forEach(strategy -> userStrategyMapper.save(new UserStrategyDo(strategy.getId(), user.getId())));
        }
        return findById(user.getId());
    }

    @Override
    public Page<User> pageUser(Integer pageNum, Integer pageSize) {
        Page<UserDo> userDoPage = userMapper.findAll(new QPageRequest(pageNum, pageSize));
        List<UserDo> userDos = userDoPage.getContent();
        ArrayList<User> users = new ArrayList<>();
        userDos.parallelStream().forEach(userDo -> {
            User user = findById(userDo.getId());
            users.add(user);
        });
        return new PageImpl<>(users, new QPageRequest(pageNum, pageSize), userDoPage.getTotalElements());
    }
}
