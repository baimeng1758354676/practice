package com.example.demo.dao.impl;

import com.example.demo.dao.LoginLogDao;
import com.example.demo.domain.bo.LoginLog;
import com.example.demo.domain.dataobject.LoginLogDo;
import com.example.demo.mapper.LoginLogMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginLogDaoImpl implements LoginLogDao {

    @Autowired
    LoginLogMapper loginLogMapper;

    @Override
    public LoginLog save(LoginLog loginLog) {
        LoginLogDo loginLogDo = new LoginLogDo();
        BeanUtils.copyProperties(loginLog, loginLogDo);
        loginLogMapper.save(loginLogDo);
        BeanUtils.copyProperties(loginLogDo, loginLog);
        return loginLog;
    }

    @Override
    public List<LoginLog> findByUserId(Integer userId) {
        ArrayList<LoginLog> loginLogs = new ArrayList<>();
        loginLogMapper.findAllByUserId(userId).parallelStream().forEach(loginLogDo -> {
            LoginLog loginLog = new LoginLog();
            BeanUtils.copyProperties(loginLogDo, loginLog);
            loginLogs.add(loginLog);
        });
        return loginLogs;
    }
}
