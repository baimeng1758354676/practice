package com.example.demo.dao.impl;

import com.example.demo.dao.UserStrategyDao;
import com.example.demo.domain.UserStrategy;
import com.example.demo.domain.UserStrategyDo;
import com.example.demo.mapper.UserStrategyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStrategyDaoImpl implements UserStrategyDao {

    @Autowired
    UserStrategyMapper userStrategyMapper;

    @Override
    public UserStrategy save(UserStrategy userStrategy) {
        UserStrategyDo userStrategyDo = new UserStrategyDo();
        BeanUtils.copyProperties(userStrategy,userStrategyDo);
        UserStrategyDo save = userStrategyMapper.save(userStrategyDo);
        BeanUtils.copyProperties(save,userStrategy);
        return userStrategy;
    }
}
