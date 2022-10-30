package com.ustc.dao.impl;

import com.ustc.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author : wtq
 * @date: 2022/10/27
 */
@Repository
public class UserDaoImpl implements UserDao {


    @Override
    public void getUser() {
        System.out.println("使用Autowired注解,使用方法见UserController类");
    }
}
