package com.example.demo.domain.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Create Table
 * <p>
 * CREATE TABLE `rule` (
 * `id` int(11) NOT NULL AUTO_INCREMENT,
 * `rule_name` varchar(128) DEFAULT '0' COMMENT '首次登陆是否强制修改密码  1 开启 0 关闭  默认1',
 * `rule_status` int(11) DEFAULT '1' COMMENT '是否开启密码生存周期，1 开启 0 关闭 默认1',
 * `rule_cycle` int(11) DEFAULT '1' COMMENT '新密码不允许与旧密码重复的设置  不允许与之前多少次重复 默认 1',
 * `rule_force` int(11) DEFAULT '1' COMMENT '新密码不允许与旧密码重复的设置 1 开启 0 关闭 默认1',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4
 */
@Entity(name = "rule")
public class RuleDo implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "rule_name")
    private String ruleName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }


}
