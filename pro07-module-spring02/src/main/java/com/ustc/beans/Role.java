package com.ustc.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author : wtq
 * @date: 2022/10/27
 */
public class Role {
    @Value("吴鑫海2号")
    private String name;
    @Value("${mysql.name}")
    private String sqlName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSqlName() {
        return sqlName;
    }

    public void setSqlName(String sqlName) {
        this.sqlName = sqlName;
    }
}
