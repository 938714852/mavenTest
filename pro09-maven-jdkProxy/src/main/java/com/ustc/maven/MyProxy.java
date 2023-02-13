package com.ustc.maven;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Miracle
 * @date 2023/2/13 19:15
 * @description Proxy
 */
public class MyProxy {
    public static Object createProxy(Object needProxy){
        ClassLoader classLoader = needProxy.getClass().getClassLoader();
        Class<?>[] interfaces = needProxy.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandler() {
            //代理类的执行方法
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("日志：调用的方法，参数是：" + Arrays.asList(args));
                //执行被代理的方法
                /**
                 * 2个参数
                 * Object obj 被代理的对象
                 * Object ... args 被代理的方法参数，直接将args传进去
                 *
                 */
                Object result = method.invoke(needProxy, args);
                System.out.println("日志：" + result);
                return result;
            }
        };
        Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
        System.out.println(o.getClass());
        return o;
    }
}
