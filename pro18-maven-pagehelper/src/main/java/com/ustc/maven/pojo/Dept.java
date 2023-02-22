package com.ustc.maven.pojo;

import java.io.Serializable;

/**
 * @author Miracle
 * @date 2023/2/21 15:37
 * @description Dept
 */
public class Dept implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
