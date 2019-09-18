package com.example.demo.mapper;

import com.example.demo.domain.dataobject.UserStrategyDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface UserStrategyMapper extends JpaRepository<UserStrategyDo, Integer> {

    List<UserStrategyDo> findByUserId(int id);
}
