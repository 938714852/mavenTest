package com.ustc.service.impl;

import com.ustc.beans.Role;
import com.ustc.dao.UserDao;
import com.ustc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : wtq
 * @date: 2022/10/27
 */

//@Service("roleService")
@Service
public class RoleServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public Role getUser() {
        userDao.getUser();
        System.out.println("RoleServiceImpl");
        return null;
    }
}
