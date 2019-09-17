package com.example.demo.domain;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author baimeng
 */
public class Strategy {
    private Integer id;

    @Column(name = "strategy_id")
    private String strategyId;

    @Column(name = "strategy_name")
    private String strategyName;

    @Column(name = "strategy_state")
    private Integer strategyState;

    @Column(name = "strategy_createtime")
    private LocalDateTime strategyCreatetime;

    private List<Rule> rules;

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public Integer getStrategyState() {
        return strategyState;
    }

    public void setStrategyState(Integer strategyState) {
        this.strategyState = strategyState;
    }

    public LocalDateTime getStrategyCreatetime() {
        return strategyCreatetime;
    }

    public void setStrategyCreatetime(LocalDateTime strategyCreatetime) {
        this.strategyCreatetime = strategyCreatetime;
    }

}
