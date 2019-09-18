package com.example.demo.domain.bo;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

public class LoginLog implements Serializable {
    public LoginLog() {
    }

    public LoginLog(Integer userId, LocalDateTime loginTime, String loginPlace) {

        this.userId = userId;
        this.loginTime = loginTime;
        this.loginPlace = loginPlace;
    }

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
