package com.example.demo.domain.bo;

import javax.persistence.Column;
import java.io.Serializable;

public class UserStrategy implements Serializable {
    private Integer id;

    @Column(name = "strategy_id")
    private Integer strategyId;

    @Column(name = "user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
