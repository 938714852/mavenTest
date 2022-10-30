package com.ustc.controller;

import com.ustc.beans.User;
import com.ustc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author : wtq
 * @date: 2022/10/27
 */
@Controller
public class UserController {
    /*
     *使用@Autowired来实现自动注入
     bytype byname
     · 默认优先根据类型去匹配
     · 如果匹配到多个类型，会根据名字去匹配（首字母小写的名字）
     · 如果名字没有匹配到，则会报错：
     *                  1、可以去修改属性的对应的bean的名字：userServiceImpl
     *                  2、可以去修改bean的名字去对应属性的名字 @Service("userService")
     *                  3、可以通过@Qualifier("userServiceImpl")设置属性的名字(覆盖)
     *                  4、通过@Primary 设置其中一个bean为主要bean （优先级高于名字匹配等）
     *                  5、使用泛型作为自动注入限定符 UserService<User> roleServiceImpl
     */
    /**
     * @Autowired 和 @Resource区别
     * @Resource 依赖JDK 优先根据名字匹配
     * @Autowired 依赖spring 优先根据类型匹配
     */
    @Autowired
    //@Qualifier("userServiceImpl")
            UserService roleServiceImpl;

    public void getUser() {
        roleServiceImpl.getUser();
    }
}
