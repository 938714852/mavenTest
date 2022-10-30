package com.ustc.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : wtq
 * @date: 2022/10/27
 */
@Component
public class User {

    /*
     * 使用@Value设置依赖注入的属性
     * 1、除了可以写硬编码值
     * 2、还可以写${}、#{}
     **/

    @Value("吴鑫海")
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
