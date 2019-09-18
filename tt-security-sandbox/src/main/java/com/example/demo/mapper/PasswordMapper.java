package com.example.demo.mapper;

import com.example.demo.domain.PasswordDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PasswordMapper extends JpaRepository<PasswordDo, Integer> {

    List<PasswordDo> findAllByUserId(Integer id);
}
