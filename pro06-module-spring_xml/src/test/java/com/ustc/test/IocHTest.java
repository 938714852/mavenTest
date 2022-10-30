package com.ustc.test;

import model.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocHTest {
    ApplicationContext ioc;
    @Before
    public void before(){
        ioc = new ClassPathXmlApplicationContext("spring2.xml");
    }
    @Test
    public void test01(){
        Person person = ioc.getBean("person",Person.class);
        System.out.println(person);
    }
}
