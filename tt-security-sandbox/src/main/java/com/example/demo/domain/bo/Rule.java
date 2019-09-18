package com.example.demo.domain.bo;

import javax.persistence.Column;
import java.io.Serializable;

public class Rule implements Serializable {
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
