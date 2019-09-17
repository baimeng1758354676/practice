package com.example.demo.controller;


import com.example.demo.domain.Strategy;
import com.example.demo.domain.UserStrategy;
import com.example.demo.domain.UserStrategyDo;
import com.example.demo.service.StrategyService;
import com.example.demo.service.UserStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
public class StrategyController {

    @Autowired
    StrategyService strategyService;

    @Autowired
    UserStrategyService userStrategyService;

    @GetMapping(value = "/checkStrategyName")
    public Strategy checkStrategyName(@RequestParam(value = "name") String name) {
        return strategyService.checkStrategyName(name);
    }
    /**
     * 新增策略
     * @param strategy
     * @return
     */

    @PostMapping(value = "/save")
    public Strategy saveStrategy(@RequestBody Strategy strategy) {
        return strategyService.saveStrategy(strategy);
    }


    /**
     * 修改策略
     * @param strategy
     * @return
     */
    @PostMapping(value = "/update")
    public Strategy updateStrategy(@RequestBody Strategy strategy) {
        return strategyService.updateStrategy(strategy);
    }

    /**
     * 策略分页
     * @param pageSize
     * @param pageNum
     * @return
     */


    @GetMapping(value = "/pageStrategy")
    public Page<Strategy> pageStrategy(int pageSize, int pageNum) {
        return strategyService.pageStrategy(pageSize, pageNum);
    }

    /**
     * 给用户配置密码策略
     * @param userStrategy
     * @return
     */

    @PostMapping(value = "/configureStrategy")
    public UserStrategy configureStrategy(@RequestBody UserStrategy userStrategy) {
       return userStrategyService.configureStrategy(userStrategy);
    }


}
