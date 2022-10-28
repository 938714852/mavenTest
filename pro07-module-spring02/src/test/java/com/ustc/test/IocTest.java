package com.ustc.test;

import com.ustc.beans.User;
import com.ustc.controller.UserController;
import com.ustc.dao.UserDao;
import com.ustc.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wtq
 * @date: 2022/10/27
 */
public class IocTest {
    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring_ioc.xml");
    }

    @Test
    public void test01(){
        UserController controller = ioc.getBean(UserController.class);
        //将类名的首字母小写设置为Bean的名字
        UserDaoImpl dao = (UserDaoImpl) ioc.getBean("userDaoImpl");
        System.out.println("controller已加载   " + controller);
        System.out.println("dao已加载   " + dao);
    }

    @Test
    public void test02(){
        User user = ioc.getBean(User.class);
        System.out.println(user.getName() + "   " + user.getSqlName());
    }

    @Test
    public void test03(){
        UserDao userDao = ioc.getBean(UserDao.class);
        userDao.getUser();
    }
    @Test
    public void test04(){
        UserController userController = ioc.getBean(UserController.class);
        userController.getUser();
    }
}
