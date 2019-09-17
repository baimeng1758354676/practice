package com.example.demo.domain;

import javax.persistence.Column;

public class StrategyRule  {
    public StrategyRule(Integer ruleId, Integer strategyId) {
        this.ruleId = ruleId;
        this.strategyId = strategyId;
    }

    private Integer id;

    @Column(name = "rule_id")
    private Integer ruleId;


    @Column(name = "strategy_id")
    private Integer strategyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }
}
