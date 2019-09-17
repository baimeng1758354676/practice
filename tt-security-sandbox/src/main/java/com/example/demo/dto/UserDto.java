package com.example.demo.dto;

import com.example.demo.domain.RuleDo;
import com.example.demo.domain.StrategyDo;
import com.example.demo.domain.UserDo;

import java.io.Serializable;
import java.util.List;

public class UserDto implements Serializable {
    private UserDo userDo;
    private List<RuleDo> ruleDos;
    private StrategyDo strategyDo;

    public UserDto(UserDo userDo, List<RuleDo> ruleDos, StrategyDo strategyDo) {
        this.userDo = userDo;
        this.ruleDos = ruleDos;
        this.strategyDo = strategyDo;
    }

    public UserDo getUser() {
        return userDo;
    }

    public void setUser(UserDo userDo) {
        this.userDo = userDo;
    }

    public List<RuleDo> getRules() {
        return ruleDos;
    }

    public void setRules(List<RuleDo> ruleDos) {
        this.ruleDos = ruleDos;
    }

    public StrategyDo getStrategy() {
        return strategyDo;
    }

    public void setStrategy(StrategyDo strategyDo) {
        this.strategyDo = strategyDo;
    }
}
