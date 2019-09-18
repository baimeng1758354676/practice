package com.example.demo.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private Integer id;

    @Column(name = "username")

    private String userName;

    private String password;

    private String name;

    @Column(name = "english_name")
    private String englishName;

    private String sex;

    private String phone;

    private Integer status;

    private String email;

    @Column(name = "user_number")
    private String userNumber;
    @Column(name = "login_sign")
    private Integer loginSign;

    private List<Strategy> strategies;

    private List<Password> passwords;

    public List<Password> getPasswords() {
        return passwords;
    }

    public void setPasswords(List<Password> passwords) {
        this.passwords = passwords;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getLoginSign() {
        return loginSign;
    }

    public void setLoginSign(Integer loginSign) {
        this.loginSign = loginSign;
    }

    public List<Strategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<Strategy> strategies) {
        this.strategies = strategies;
    }


}
