package com.example.demo.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class Rule implements Serializable {
    private Integer id;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "rule_status")
    private Integer ruleStatus;


    @Column(name = "rule_cycle")
    private Integer ruleCycle;


    @Column(name = "rule_force")
    private Integer ruleForce;

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
}
