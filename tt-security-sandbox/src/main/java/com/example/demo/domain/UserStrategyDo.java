package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * CREATE TABLE `user_strategy` (
 *   `id` int(10) NOT NULL,
 *   `strategy_id` int(10) NOT NULL,
 *   `user_id` int(10) NOT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb
 */

@Entity(name = "user_strategy")
public class UserStrategyDo implements Serializable {
    @Id
    @GeneratedValue
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
