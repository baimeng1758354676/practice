package com.example.demo.mapper;

import com.example.demo.domain.PasswordDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordMapper extends JpaRepository<PasswordDo, Integer> {

    List<PasswordDo> findAllByUserId(Integer id);
}
