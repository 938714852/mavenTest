package com.ustc.test;

import com.ustc.IocJavaConfig;
import com.ustc.beans.*;
import com.ustc.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : wtq
 * @date: 2022/10/30
 */
public class JavaConfigTest {

    ApplicationContext ioc;

    @Before
    public void before() {
        ioc = new AnnotationConfigApplicationContext(IocJavaConfig.class);
    }

    @Test
    public void test01() {
        UserController userController = ioc.getBean(UserController.class);
        userController.getUser();
    }

    /**
     * @Import(SecondJavaConfig.class,Role.class)
     */
    @Test
    public void test02() {
//        User user = ioc.getBean(User.class);
        User user1 = (User)ioc.getBean("user");
        Role role = ioc.getBean("role",Role.class);
        System.out.println(user1.getName() + "------" + user1.getSqlName() + "   Role.name():  " + role.getName());
    }

    /**
     * @Import(MyImportSelector.class)
     */
    @Test
    public void test03(){
        Person person = ioc.getBean(Person.class); //必须用类型的方式获取，不能通过名字获取
        System.out.println("person.getName(): " + person.getName());
    }

    /**
     * @Import(MyImportBeanDefinitionRegistrar.class)
     */
    @Test
    public void test04(){
        Person person = (Person) ioc.getBean("person");
        System.out.println("MyImportBeanDefinitionRegistrar:  " + person.getName());
    }
}
