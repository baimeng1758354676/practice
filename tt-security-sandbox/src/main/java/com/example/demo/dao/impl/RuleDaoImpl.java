package com.example.demo.dao.impl;

import com.example.demo.dao.RuleDao;
import com.example.demo.domain.Rule;
import com.example.demo.domain.RuleDo;
import com.example.demo.domain.StrategyRuleDo;
import com.example.demo.mapper.RuleMapper;
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


    @Autowired
    RuleMapper ruleMapper;

    @Override
    public List<Rule> findByStrategyId(Integer id) {
        List<StrategyRuleDo> strategyRuleDos = strategyRuleMapper.findAllByStrategyId(id);
        ArrayList<Rule> rules = new ArrayList<>();
        for (StrategyRuleDo strategyRuleDo : strategyRuleDos) {
            Rule rule = new Rule();
            BeanUtils.copyProperties(ruleMapper.findFirstById(strategyRuleDo.getRuleId()), rule);
            rules.add(rule);
        }
        return rules;
    }

    @Override
    public Rule saveRule(Rule rule) {
        RuleDo ruleDo = new RuleDo();
        BeanUtils.copyProperties(rule,ruleDo);
        RuleDo save = ruleMapper.save(ruleDo);
        BeanUtils.copyProperties(save,rule);
        return rule;
    }
}
