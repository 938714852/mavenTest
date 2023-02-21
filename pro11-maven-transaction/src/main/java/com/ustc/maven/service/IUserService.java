package com.ustc.maven.service;

import com.ustc.maven.entity.User;

/**
 * @author Miracle
 * @date 2023/2/15 15:10
 * @description UserService
 */
public interface IUserService {
    void trans();

    void sub();

    void save();

    User getUser();
}
