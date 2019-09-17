package com.example.demo;

import com.example.demo.mapper.StrategyMapper;
import com.example.demo.domain.StrategyDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    StrategyMapper strategyMapper;

    @Test
    public void contextLoads() {
        List<StrategyDo> list = strategyMapper.findByStrategyNameContains("新增");
        System.out.println(list);
    }

}
