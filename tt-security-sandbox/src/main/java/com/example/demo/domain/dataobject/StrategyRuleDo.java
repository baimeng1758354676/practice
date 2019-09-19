package com.example.demo.domain.dataobject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create Table
 * <p>
 * CREATE TABLE `strategy_rule` (
 * `id` int(10) NOT NULL AUTO_INCREMENT,
 * `rule_id` int(10) NOT NULL,
 * `strategy_id` int(10) NOT NULL,
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
 */

@Entity
@Table(name = "strategy_rule")
public class StrategyRuleDo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rule_name")
    private String ruleName;


    @Column(name = "strategy_id")
    private Integer strategyId;

    @Column(name = "rule_status")
    private Integer ruleStatus;


    @Column(name = "rule_cycle")
    private Integer ruleCycle;


    @Column(name = "rule_force")
    private Integer ruleForce;

    public Integer getRuleStatus() {
        return ruleStatus;
    }

    public void setRuleStatus(Integer ruleStatus) {
        this.ruleStatus = ruleStatus;
    }

    public Integer getRuleCycle() {
        return ruleCycle;
    }

    public void setRuleCycle(Integer ruleCycle) {
        this.ruleCycle = ruleCycle;
    }

    public Integer getRuleForce() {
        return ruleForce;
    }

    public void setRuleForce(Integer ruleForce) {
        this.ruleForce = ruleForce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }
}
