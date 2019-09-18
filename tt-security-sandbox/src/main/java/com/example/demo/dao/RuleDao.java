package com.example.demo.dao;

import com.example.demo.domain.bo.RuleInstance;

import java.util.List;

/**
 * @author baimeng
 */
public interface RuleDao {

    /**
     * 查询策略对应的规则实体集合
     *
     * @param id 策略主键
     * @return
     */
    List<RuleInstance> findByStrategyId(Integer id);

    /**
     * 新增规则实体
     *
     * @param ruleInstance
     * @return
     */
    RuleInstance saveRule(RuleInstance ruleInstance);


}
