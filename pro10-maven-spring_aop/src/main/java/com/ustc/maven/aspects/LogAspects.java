package com.ustc.maven.aspects;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * @author Miracle
 * @date 2023/2/14 13:01
 * @description LogAspects
 */
@Aspect    //标记为切面
@Component //标记bean组件，才能切人到ioc当中的bean
public class LogAspects {
    //采用申明切点的方式，让其他通知引用，重用性更强
    @Pointcut("execution(* com.ustc.maven.service.impl.*.*(..))")
    public void pointCut(){
    }

    //前置通知
    //@annotation(logger)匹配制定包下，所有带有@Logger注解的方法
    //通知上面的参数不是随便能写的，JoinPoint所有的通知都可以有，其他参数视有效情况而定
    @Before("pointCut() && @annotation(logger)") //写法看有道云笔记springAOP
    public void before(JoinPoint joinPoint, Logger logger) { //可以通过JoinPoint获取参数
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println(name + " 自定义名为：" + logger.name() +  " 的方法开始执行，参数是：" + Arrays.asList(args));
    }

    //后置通知
    @After("pointCut()")
    public void after() {
        System.out.println("后置通知");
    }

    //后置异常通知
    @AfterThrowing(value = "pointCut()",
            throwing = "ex")
    public void afterThrowing(Exception ex) {
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter,true));
        System.out.println("后置异常通知,异常为：" + stringWriter.getBuffer().toString());//固定写法，获取异常栈
    }

    //后置返回通知
    @AfterReturning(value = "pointCut()", returning = "returnValue")
    public void afterReturning(Object returnValue) {
        System.out.println("后置返回通知,返回结果： " + returnValue);
    }
    //环绕通知
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object returnValue = "";
        try {
            System.out.println("环绕：前置通知" + methodName + "参数为：" + Arrays.asList(args));
            returnValue = joinPoint.proceed();
            System.out.println("环绕：后置通知" + methodName + "参数为：" + Arrays.asList(args));
        } catch (Throwable e) {
            System.out.println("环绕：异常通知" + e);;
        } finally {
            System.out.println("环绕：返回通知" + returnValue);
        }

        return returnValue;
    }

}
