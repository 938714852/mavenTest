package com.ustc.maven.dao;

import com.ustc.maven.entity.User;

/**
 * @author Miracle
 * @date 2023/2/15 15:11
 * @description IUserDao
 */
public interface IUserDao {
    User getUser();

    void sub();

    void save();
}
