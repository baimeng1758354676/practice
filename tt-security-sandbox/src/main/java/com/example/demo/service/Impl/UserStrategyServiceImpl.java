package com.example.demo.service.Impl;

import com.example.demo.dao.UserStrategyDao;
import com.example.demo.domain.UserStrategy;
import com.example.demo.mapper.UserStrategyMapper;
import com.example.demo.domain.UserStrategyDo;
import com.example.demo.service.UserStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserStrategyServiceImpl implements UserStrategyService {

    @Autowired
    UserStrategyDao userStrategyDao;

    @Override
    public UserStrategy configureStrategy(UserStrategy userStrategy) {
        return userStrategyDao.save(userStrategy);
    }
}
