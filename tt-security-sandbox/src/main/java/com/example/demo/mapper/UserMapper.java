package com.example.demo.mapper;

import com.example.demo.domain.dataobject.UserDo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends JpaRepository<UserDo, Integer> {

    List<UserDo> findAllByUserName(String name);

    UserDo findByUserNameAndPassword(String userName, String password);

    UserDo findFirstById(Integer id);

    UserDo findFirstByUserName(String userName);

    Page<UserDo> findAllBy(QPageRequest qPageRequest);
}
