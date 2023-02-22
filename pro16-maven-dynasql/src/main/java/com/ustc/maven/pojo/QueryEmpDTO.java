package com.ustc.maven.pojo;

import java.time.LocalDate;

/**
 * @author Miracle
 * @date 2023/2/21 20:07
 * @description QueryEmpDTO
 */
public class QueryEmpDTO {
    private Integer id;
    private String name;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Integer did;

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

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }
}
