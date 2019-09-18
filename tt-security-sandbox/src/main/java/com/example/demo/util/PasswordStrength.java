package com.example.demo.util;


import org.springframework.stereotype.Service;

/**
 * 密码强度工具类
 *
 * @author 刘新全
 */
@Service
public class PasswordStrength {

    public String getPasswordStrength(Integer x) {
        if (x >= 90) {
            return "非常安全";
        } else if (x >= 80 && x < 90) {
            return "安全";
        } else if (x >= 70 && x < 80) {
            return "中等";
        } else if (x >= 60 && x < 70) {
            return "一般";
        } else {
            return "未达到标准";
        }
    }
}
