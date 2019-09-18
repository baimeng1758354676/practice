package com.example.demo.mapper;

import com.example.demo.domain.dataobject.RuleDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RuleMapper extends JpaRepository<RuleDo, Integer> {

    List<RuleDo> findById(int id);

    RuleDo findFirstById(int id);


}
