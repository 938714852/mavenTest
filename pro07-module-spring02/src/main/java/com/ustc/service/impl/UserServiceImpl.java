package com.ustc.service.impl;

import com.ustc.beans.User;
import com.ustc.dao.UserDao;
import com.ustc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author : wtq
 * @date: 2022/10/27
 */

// @Service("userService")
@Service
@Primary //设置自动注入的主要bean
public class UserServiceImpl implements UserService {//通常在业务逻辑类中调用数据访问类的方法

    @Autowired
    UserDao userDao;

    @Override
    public User getUser() {
        userDao.getUser();
        System.out.println("UserServiceImpl");
        return null;
    }
}
