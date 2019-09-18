package com.example.demo.mapper;

import com.example.demo.domain.dataobject.StrategyRuleDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StrategyRuleMapper extends JpaRepository<StrategyRuleDo, Integer> {

    List<StrategyRuleDo> findAllByStrategyId(int id);

}
