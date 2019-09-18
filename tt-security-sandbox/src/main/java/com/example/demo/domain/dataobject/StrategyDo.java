package com.example.demo.domain.dataobject;
//-------------------------hello


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Create Table
 * <p>
 * CREATE TABLE `strategy` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `strategy_id` varchar(128) NOT NULL,
 * `strategy_name` varchar(128) NOT NULL,
 * `strategy_state` int(11) NOT NULL COMMENT '策略状态  1 启用 0 禁用',
 * `strategy_createtime` timestamp NULL DEFAULT NULL,
 * PRIMARY KEY (`id`),
 * KEY `idx_strategy_name` (`strategy_name`) USING HASH,
 * KEY `idx_strategy_id` (`strategy_id`) USING HASH
 * ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8
 */
@Entity(name = "strategy")
public class StrategyDo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "strategy_id")
    private String strategyId;

    @Column(name = "strategy_name")
    private String strategyName;

    @Column(name = "strategy_state")
    private Integer strategyState;

    @Column(name = "strategy_createtime")
    private LocalDateTime strategyCreatetime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
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
