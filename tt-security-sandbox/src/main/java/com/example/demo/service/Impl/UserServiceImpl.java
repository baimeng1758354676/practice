package com.example.demo.service.Impl;

import com.example.demo.dao.LoginLogDao;
import com.example.demo.dao.StrategyDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.bo.LoginLog;
import com.example.demo.domain.bo.Strategy;
import com.example.demo.domain.bo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    StrategyDao strategyDao;

    @Autowired
    LoginLogDao loginLogDao;

    public User findById(Integer id){
        User user = userDao.findById(id);
        user.setPassword(null);
        return user;
    }

    public User findByUsername(String username){
        User user = userDao.findByUserName(username);
        user.setPassword(null);
        return user;
    }

    private User setPasswordNull(User user) {
        user.setPassword(null);
        return user;
    }

    @Override
    public User checkUserName(String name) {
        return this.findByUsername(name);
    }

    @Override
    @Transactional
    public User register(User user) {
        //注册时用户关联的策略为默认策略
        List<Strategy> strategies = new ArrayList<>();
        strategies.add(strategyDao.findByName(Constant.STRATEGY_DEFAULT_NAME));
        user.setStrategies(strategies);
        return setPasswordNull(userDao.save(user));
    }

    @Override
    public User login(String username,String password) throws Exception {
        User userInfo = userDao.findByUserName(username);
        if (!ObjectUtils.isEmpty(userInfo)) {
            if (Objects.equals(userInfo.getPassword(),password)) {
                //登录成功，新增登录日志
                loginLogDao.save(new LoginLog( userInfo.getId(),LocalDateTime.now()));
                return setPasswordNull(userInfo);
            }
            throw new Exception(Constant.EXCEPTION_PASSWORD_INCORRECT);
        }
        throw new Exception(Constant.EXCEPTION_USER_NOT_EXIST);
    }

    @Override
    public User configureStrategy(Integer userId,Integer strategyId) {
        User user = this.findById(userId);
        user.getStrategies().add(strategyDao.findById(strategyId));
        return setPasswordNull(userDao.save(user));
    }

    @Override
    public List<LoginLog> findLoginLogByUserId(Integer userId) {
        return loginLogDao.findByUserId(userId);
    }

    @Override
    public User signNextChangePassword(Integer userId) {
        User user = userDao.findById(userId);
        //将标志位的值置为1
        user.setLoginSign(Constant.LOGIN_SIGN);
        return userDao.save(user);
    }

    @Override
    public Page<User> pageUser(Integer pageNum, Integer pageSize) {
        return userDao.pageUser(pageNum, pageSize);
    }

    @Override
    public User deleteUser(Integer userId) {
        User user = userDao.findById(userId);
        user.setStatus(Constant.ACCOUNT_STATUS_DELETE);
        return userDao.save(user);
    }

    @Override
    public List<User> batchDeleteUser(List<Integer> userIds) {
        ArrayList<User> userList = new ArrayList<>();
        userIds.parallelStream().forEach(userId -> {
            userList.add(deleteUser(userId));
        });
        return userList;
    }

    @Override
    public List<User> batchConfigureStrategy(Map<Integer, Integer> map) {
        List<User> userList = new ArrayList<>();
        Set<Integer> userIds = map.keySet();
        Iterator<Integer> iterator = userIds.iterator();
        while (iterator.hasNext()) {
            Integer userId = iterator.next();
            Integer strategyId = map.get(userId);
            configureStrategy(userId, strategyId);
        }
        return userList;
    }
}
