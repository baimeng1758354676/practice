package com.example.demo.dao.impl;

import com.example.demo.dao.PasswordDao;
import com.example.demo.domain.Password;
import com.example.demo.domain.PasswordDo;
import com.example.demo.mapper.PasswordMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordDaoImpl implements PasswordDao {
    @Autowired
    PasswordMapper passwordMapper;



    @Override
    public List<Password> findByUserId(Integer id) {
        List<PasswordDo> passwordDos = passwordMapper.findAllByUserId(id);
        ArrayList<Password> passwords = new ArrayList<>();
        for (PasswordDo passwordDo : passwordDos) {
            Password password = new Password();
            BeanUtils.copyProperties(passwordDo,password);
            passwords.add(password);
        }
        return passwords;
    }

    @Override
    public Password savePassword(Password password) {
        PasswordDo passwordDo = new PasswordDo();
        BeanUtils.copyProperties(password,passwordDo);
        PasswordDo save = passwordMapper.save(passwordDo);
        BeanUtils.copyProperties(save,password);
        return password;
    }
}
