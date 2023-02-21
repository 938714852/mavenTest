package com.ustc.maven.pojo;

/**
 * @author Miracle
 * @date 2023/2/20 10:06
 * @description Emp
 */
public class Emp {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
}
