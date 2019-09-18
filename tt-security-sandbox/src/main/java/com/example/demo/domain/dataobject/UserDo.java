package com.example.demo.domain.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Create Table
 * <p>
 * CREATE TABLE `user` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `username` varchar(255) DEFAULT NULL,
 * `password` varchar(255) DEFAULT NULL,
 * `name` varchar(255) DEFAULT NULL,
 * `english_name` varchar(255) DEFAULT NULL,
 * `sex` varchar(255) DEFAULT NULL,
 * `phone` varchar(255) DEFAULT NULL,
 * `status` int(11) DEFAULT '1' COMMENT '是否被禁用（0为禁用，1为开启）',
 * `email` varchar(255) DEFAULT NULL,
 * `user_number` varchar(255) DEFAULT NULL,
 * `login_count` int(255) DEFAULT '0' COMMENT '登录次数',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
 */

@Entity(name = "user")
public class UserDo implements Serializable {

    @Id
    @GeneratedValue
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
}
