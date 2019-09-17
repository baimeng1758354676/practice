package com.example.demo.service;

import com.example.demo.domain.UserStrategy;
import com.example.demo.domain.UserStrategyDo;

public interface UserStrategyService {
    UserStrategy configureStrategy(UserStrategy userStrategy);
}
