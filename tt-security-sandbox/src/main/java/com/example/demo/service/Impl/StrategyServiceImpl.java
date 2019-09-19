package com.example.demo.service.Impl;

import com.example.demo.dao.StrategyDao;
import com.example.demo.domain.bo.Strategy;
import com.example.demo.mapper.StrategyMapper;
import com.example.demo.service.StrategyService;
import com.example.demo.util.Constant;
import com.example.demo.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class StrategyServiceImpl implements StrategyService {

    @Autowired
    StrategyMapper strategyMapper;

    @Autowired
    StrategyDao strategyDao;


    /**
     * 密码策略分页
     *
     * @param pageSize
     * @param pageNum
     * @return
     */

    @Override
    public Page<Strategy> pageStrategy(int pageSize, int pageNum) {
        return strategyDao.pageStrategy(pageSize, pageNum);
    }

    @Override
    public Strategy checkStrategyName(String name) {
        return strategyDao.findByName(name);
    }

    @Override
    @Scheduled(cron = "0,55 * * * * ? ")
    public Strategy saveStrategy(Strategy strategy) {
//        生成并校验编号唯一性
        boolean flag = true;
        while (flag) {
            //生成密码策略编号 MMCL + 10位数字
            String strategyId = Constant.STRATEGY_PREFIX + RandomUtil.getRandom(Constant.STRATEGY_POSTFIX_LENGTH);
            Strategy result = strategyDao.findByStrategyId(strategyId);
            if (ObjectUtils.isEmpty(result)) {
                //结果为空，编号唯一
                strategy.setStrategyId(strategyId);
                flag = false;
            }
        }
        return strategyDao.saveStrategy(strategy);
    }

    @Override
    public Strategy updateStrategy(Strategy strategy) {
        return strategyDao.saveStrategy(strategy);
    }
}
