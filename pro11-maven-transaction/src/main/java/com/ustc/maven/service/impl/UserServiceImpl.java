package com.ustc.maven.service.impl;

import com.ustc.maven.dao.IUserDao;
import com.ustc.maven.entity.User;
import com.ustc.maven.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Miracle
 * @date 2023/2/15 15:11
 * @description UserServiceImpl
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    /**
     * 转账
     */
    //@Transactional可以类和方法上面同时都存在， 如果类和方法都存在@Transactional会以方法的为准。如果方法上面没有@Transactional会以类上面的为准
    //建议：@Transactional写在方法上面，控制粒度更细，   建议@Transactional写在业务逻辑层上，因为只有业务逻辑层才会有嵌套调用的情况。
    @Transactional
    @Override
    public void trans(){
        sub();
        int i = 1/0;
        save();
    }

    /**
     * 取钱
     */
    @Override
    public void sub(){
        System.out.println("扣钱");
        userDao.sub();
    }

    /**
     * 存钱
     */
    @Override
    public void save(){
        System.out.println("加钱");
        userDao.save();

    }



    @Override
    public User getUser(){
        return userDao.getUser();
    }


}
