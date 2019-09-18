package com.example.demo.service;

import com.example.demo.domain.bo.Strategy;
import org.springframework.data.domain.Page;

public interface StrategyService {
    Page<Strategy> pageStrategy(int pageSize, int pageNum);

    Strategy checkStrategyName(String name);

    Strategy saveStrategy(Strategy strategy);

    Strategy updateStrategy(Strategy strategy);
}
