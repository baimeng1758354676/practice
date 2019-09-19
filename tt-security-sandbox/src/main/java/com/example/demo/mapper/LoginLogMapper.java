package com.example.demo.mapper;

import com.example.demo.domain.dataobject.LoginLogDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author baimeng
 */
@Component
public interface LoginLogMapper extends JpaRepository<LoginLogDo, Integer> {
    List<LoginLogDo> findAllByUserId(Integer userId);
}
