package com.example.demo.dao;

import com.example.demo.domain.bo.Strategy;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author baimeng
 */
public interface StrategyDao {

    Strategy findById(Integer id);

    Strategy findByName(String name);

    Strategy findByStrategyId(String id);

    /**
     * 查询用户对应的策略集合
     *
     * @param id 用户主键
     * @return
     */
    List<Strategy> findByUserId(Integer id);

    /**
     * 新增策略
     *
     * @param strategy
     * @return
     */
    Strategy saveStrategy(Strategy strategy);

    Page<Strategy> pageStrategy(int pageSize, int pageNum);
}
