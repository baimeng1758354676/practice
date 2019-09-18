package com.example.demo.domain.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author baimeng
 */
@Entity(name = "login_log")
public class LoginLogDo implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login_time")
    private LocalDateTime loginTime;

    @Column(name = "login_place")
    private String loginPlace;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginPlace() {
        return loginPlace;
    }

    public void setLoginPlace(String loginPlace) {
        this.loginPlace = loginPlace;
    }
}
