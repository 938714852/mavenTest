package com.ustc.maven.entity;

/**
 * @author Miracle
 * @date 2023/2/15 15:07
 * @description User
 */
public class User {
    private Integer id;
    private String username;
    private String cardno;
    private Integer balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cardno='" + cardno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
