package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Autowired
//    StrategyDao strategyDao;
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<StrategyDo> list = strategyDao.findByStrategyNameContains("新增");
//        System.out.println(list);
//    }
}
