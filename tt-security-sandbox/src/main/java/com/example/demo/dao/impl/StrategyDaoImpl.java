package com.example.demo.dao.impl;

import com.example.demo.dao.RuleDao;
import com.example.demo.dao.StrategyDao;
import com.example.demo.domain.bo.Rule;
import com.example.demo.domain.bo.Strategy;
import com.example.demo.domain.dataobject.StrategyDo;
import com.example.demo.domain.dataobject.StrategyRuleDo;
import com.example.demo.domain.dataobject.UserStrategyDo;
import com.example.demo.mapper.StrategyMapper;
import com.example.demo.mapper.StrategyRuleMapper;
import com.example.demo.mapper.UserStrategyMapper;
import com.example.demo.util.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StrategyDaoImpl implements StrategyDao {

    @Autowired
    RuleDao ruleDao;

    @Autowired
    StrategyMapper strategyMapper;

    @Autowired
    UserStrategyMapper userStrategyMapper;

    @Autowired
    StrategyRuleMapper strategyRuleMapper;


    @Override
    public Strategy findById(Integer id) {
        List<Rule> rules = ruleDao.findByStrategyId(id);
        Strategy strategy = new Strategy();
        strategy.setRules(rules);
        StrategyDo strategyDo = strategyMapper.findFirstById(id);
        BeanUtils.copyProperties(strategyDo, strategy);
        return strategy;
    }

    @Override
    public Strategy findByName(String name) {
        return findById(strategyMapper.findFirstByStrategyName(name).getId());
    }

    @Override
    public Strategy findByStrategyId(String id) {
        return findById(strategyMapper.findFirstByStrategyId(id).getId());
    }

    @Override
    public List<Strategy> findByUserId(Integer id) {
        List<UserStrategyDo> userStrategyDos = userStrategyMapper.findByUserId(id);
        ArrayList<Strategy> strategies = new ArrayList<>();
        for (UserStrategyDo userStrategyDo : userStrategyDos) {
            Strategy strategy = findById(userStrategyDo.getStrategyId());
            strategies.add(strategy);
        }
        return strategies;
    }

    @Override
    public Strategy saveStrategy(Strategy strategy) {
        StrategyDo strategyDo = new StrategyDo();
        BeanUtils.copyProperties(strategy, strategyDo);
        StrategyDo save = strategyMapper.save(strategyDo);
        BeanUtils.copyProperties(save, strategy);
        //传过来的规则
        List<Rule> rules = strategy.getRules();
        //返回的规则
        rules.parallelStream().map(rule -> ruleDao.saveRule(rule)).forEach(t -> {
            StrategyRuleDo strategyRuleDo = new StrategyRuleDo();
            strategyRuleDo.setRuleId(t.getId());
            strategyRuleDo.setStrategyId(strategyDo.getId());
            strategyRuleMapper.save(strategyRuleDo);
        });

        return strategy;
    }

    @Override
    public Page<Strategy> pageStrategy(int pageSize, int pageNum) {
        Page<StrategyDo> page = strategyMapper.findAllByStrategyState(Constant.STRATEGY_STATE, new QPageRequest(pageNum, pageSize));
        List<StrategyDo> content = page.getContent();
        List<Strategy> newContent = content.parallelStream().map(strategyDo -> findById(strategyDo.getId())).collect(Collectors.toList());
        return new PageImpl<>(newContent, page.getPageable(), page.getTotalElements());
    }
}
