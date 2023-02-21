package com.ustc.maven.service.impl;

import com.ustc.maven.dao.IUserDao;
import com.ustc.maven.entity.User;
import com.ustc.maven.service.IUserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Miracle
 * @date 2023/2/13 20:46
 * @description UserServiceImpl
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    @Override
    @Logger(name = "查询方法")
    public User select(Integer id) throws Exception {
        System.out.println("查询user");
        return userDao.select(id);
    }

    @Override
    public void add(User user) throws Exception {
        System.out.println("增加user");
        userDao.add(user);
    }

    @Override
    public void updata(User user) throws Exception {
        System.out.println("更新user");
        userDao.updata(user);
    }

    @Override
    public void delete(Integer id) throws Exception {
        System.out.println("删除user");
        userDao.delete(id);
    }
}
