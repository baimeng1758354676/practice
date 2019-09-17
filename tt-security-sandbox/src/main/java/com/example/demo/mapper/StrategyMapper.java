package com.example.demo.mapper;

import com.example.demo.domain.Strategy;
import com.example.demo.domain.StrategyDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface StrategyMapper extends JpaRepository<StrategyDo, Integer> {

    List<StrategyDo> findByStrategyNameContains(String s);

    StrategyDo findByStrategyId(String strategyId);

    Page<StrategyDo> findAllByStrategyState(int state, Pageable pageable);

    List<StrategyDo> findByStrategyName(String name);

    StrategyDo findFirstById(int id);

    StrategyDo findFirstByStrategyName(String name);

    StrategyDo findFirstByStrategyId(String strategyId);
}
