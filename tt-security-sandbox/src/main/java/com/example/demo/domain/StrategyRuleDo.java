package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 Create Table

 CREATE TABLE `strategy_rule` (
 `id` int(10) NOT NULL AUTO_INCREMENT,
 `rule_id` int(10) NOT NULL,
 `strategy_id` int(10) NOT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

 */

@Entity(name = "strategy_rule")
public class StrategyRuleDo implements Serializable {

    @Id
    @GeneratedValue
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
