package com.example.demo.dao;

import com.example.demo.domain.Rule;
import com.example.demo.domain.RuleDo;

import java.util.List;

/**
 * @author baimeng
 */
public interface RuleDao  {

    /**
     * 查询策略对应的规则集合
     * @param id 策略主键
     * @return
     */
    List<Rule> findByStrategyId(Integer id);

    /**
     * 新增规则
     * @param rule
     * @return
     */
    Rule saveRule(Rule rule);


}
