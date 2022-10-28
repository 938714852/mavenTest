package com.ustc.test;

import model.Person;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;

public class IocTest {
    ApplicationContext ioc;
    @Before
    public void before(){  //每个test都是先加载before的内容
        //加载ioc容器
        //ApplicationContext spring的顶层核心接口
        //ClassPathXmlApplicationContext 根据项目路径的xml配置来实例化spring容器
        //FileSystemXmlApplicationContext 根据磁盘路径的xml配置来实例化spring容器
        //AnnotationConfigApplicationContext 根据javaConfig来配置
        ioc = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void test01(){
        //获取Bean
        //1、通过类来获取bean    getBean(IUserService.class)
        //2、通过bean的名字或id来获取bean    (IUserService)ioc.getBean("userService")  需要强转
        //3、通过名字+类型   不需要强转  当建立了两个IUserService的Bean时，无法使用第一种方法，需要通过名字匹配
        //IUserService service = ioc.getBean(IUserService.class);
        //IUserService service = (IUserService) ioc.getBean("userService");
        IUserService service = ioc.getBean("userService",IUserService.class);

        service.getUser();

        //IUserService userService = new UserServiceImpl();
        //userService.getUser();
    }

    @Test
    public void test02(){
        User user = ioc.getBean("user4",User.class);
        System.out.println(user);

    }
    @Test
    public void test03(){
        Person person = ioc.getBean("person",Person.class);
        System.out.println(person);


    }
}
