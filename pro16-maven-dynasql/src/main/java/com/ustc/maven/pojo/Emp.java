package com.ustc.maven.pojo;


import java.time.LocalDate;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
public class Emp {
    private Integer id;
    private String name;
    private LocalDate cjsj;
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

    public void setName(String username) {
        this.name = username;
    }

    public LocalDate getCjsj() {
        return cjsj;
    }

    public void setCjsj(LocalDate cjsj) {
        this.cjsj = cjsj;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cjsj=" + cjsj +
                ", did=" + did +
                '}';
    }

    public Emp(Integer id, String username) {
        this.id = id;
        this.name = username;
    }

    public Emp() {
    }

    public Emp(Integer id, String name, LocalDate cjsj, Integer did) {
        this.id = id;
        this.name = name;
        this.cjsj = cjsj;
        this.did = did;
    }
}
