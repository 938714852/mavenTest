package com.ustc.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author : wtq
 * @date: 2022/10/30
 */
public class Wife {
    @Value("spring")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
