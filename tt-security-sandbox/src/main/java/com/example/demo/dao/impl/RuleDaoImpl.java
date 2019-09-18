package com.example.demo.dao.impl;

import com.example.demo.dao.RuleDao;
import com.example.demo.domain.bo.RuleInstance;
import com.example.demo.domain.dataobject.StrategyRuleDo;
import com.example.demo.mapper.StrategyRuleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleDaoImpl implements RuleDao {

    @Autowired
    StrategyRuleMapper strategyRuleMapper;


    @Override
    public List<RuleInstance> findByStrategyId(Integer id) {
        List<StrategyRuleDo> strategyRuleDos = strategyRuleMapper.findAllByStrategyId(id);
        ArrayList<RuleInstance> ruleInstances = new ArrayList<>();
        strategyRuleDos.parallelStream().forEach(strategyRuleDo -> {
            RuleInstance ruleInstance = new RuleInstance();
            BeanUtils.copyProperties(strategyRuleDo, ruleInstance);
            ruleInstances.add(ruleInstance);
        });

        return ruleInstances;
    }

    @Override
    public RuleInstance saveRule(RuleInstance ruleInstance) {
        StrategyRuleDo strategyRuleDo = new StrategyRuleDo();
        BeanUtils.copyProperties(ruleInstance, strategyRuleDo);
        strategyRuleMapper.save(strategyRuleDo);
        BeanUtils.copyProperties(strategyRuleDo, ruleInstance);
        return ruleInstance;
    }
}
